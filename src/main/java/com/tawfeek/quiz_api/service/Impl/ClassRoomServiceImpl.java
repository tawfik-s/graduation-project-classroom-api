package com.tawfeek.quiz_api.service.Impl;

import com.tawfeek.quiz_api.entity.ClassRoom;
import com.tawfeek.quiz_api.entity.User;
import com.tawfeek.quiz_api.exception.ConflictException;
import com.tawfeek.quiz_api.exception.RecordNotFoundException;
import com.tawfeek.quiz_api.mapper.ClassRoomMapper;
import com.tawfeek.quiz_api.mapper.UserMapper;
import com.tawfeek.quiz_api.model.classRoom.AddingUserToClassRoomRequestDTO;
import com.tawfeek.quiz_api.model.classRoom.ClassRoomRequestDTO;
import com.tawfeek.quiz_api.model.classRoom.ClassRoomResponseDTO;
import com.tawfeek.quiz_api.model.classRoom.UserAddingToClassRoomStatusResponseDTO;
import com.tawfeek.quiz_api.model.user.UserResponseDTO;
import com.tawfeek.quiz_api.repository.ClassRoomRepository;
import com.tawfeek.quiz_api.repository.UserRepository;
import com.tawfeek.quiz_api.service.ClassRoomService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.tawfeek.quiz_api.Utils.SecurityUtils.getCurrentUserEmail;


@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional
    public ClassRoomResponseDTO createClassRoom(ClassRoomRequestDTO classRoomRequestDTO) {
        String email = getCurrentUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow();
        ClassRoom classRoom = classRoomMapper.toEntity(classRoomRequestDTO);
        classRoomRepository.save(classRoom);
        user.getClassRooms().add(classRoom);
        userRepository.save(user);
        return classRoomMapper.toDTO(classRoom);
    }


    @Override
    public List<ClassRoomResponseDTO> getOwnedClassRooms() {
        String email = getCurrentUserEmail();
        return userRepository.findByEmail(email).orElseThrow()
                .getClassRooms().stream()
                .map(classRoom -> classRoomMapper.toDTO(classRoom))
                .toList();
    }

    @Override
    public List<ClassRoomResponseDTO> getClassRoomsUserMemberOf() {
        String email = getCurrentUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow();
        return classRoomRepository.findClassRoomUserMemberOf(user)
                .orElseThrow().stream()
                .map(classRoom ->
                        classRoomMapper.toDTO(classRoom))
                .toList();
    }

    @Override
    @Transactional
    public void deleteClassRoom(Long classRoomId) {
        String email = getCurrentUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow();
        if (classRoomRepository.isUserAdminOfClassRoom(classRoomId, user.getId())) {
            classRoomRepository.deleteById(classRoomId);
        } else {
            throw new RecordNotFoundException("not find ClassRoom in your class rooms");
        }

    }

    @Override
    public List<UserResponseDTO> getClassRoomMembers(Long classRoomId) {
        String email = getCurrentUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow();
        if (classRoomRepository.isUserAdminOfClassRoom(classRoomId, user.getId()) ||
                classRoomRepository.isUserMemberOfClassRoom(classRoomId, user.getId())) {
            return classRoomRepository.getClassRoomMembers(classRoomId)
                    .orElseThrow().stream()
                    .map(u -> userMapper.toDTO(u)).toList();
        } else {
            throw new RecordNotFoundException("not find ClassRoom in your class rooms");
        }
    }

    @Override
    @Transactional
    public void deleteClassRoomMember(Long classRoomId, Long memberId) {
        String email = getCurrentUserEmail();
        var user = userRepository.findByEmail(email).orElseThrow();
        if (!classRoomRepository.isUserAdminOfClassRoom(classRoomId, user.getId())) {
            throw new RecordNotFoundException("you are not the class room owner");
        }
        classRoomRepository.deleteMemberFromClassRoom(classRoomId,
                userRepository.findById(memberId).orElseThrow());
    }

    @Override
    @Transactional
    public UserAddingToClassRoomStatusResponseDTO addMemberToClassRoom(Long classRoomId, AddingUserToClassRoomRequestDTO addingUserToClassRoomRequestDTO) {
        String email = getCurrentUserEmail();
        var user = userRepository.findByEmail(email).orElseThrow();
        if (!classRoomRepository.isUserAdminOfClassRoom(classRoomId, user.getId())) {
            throw new IllegalArgumentException("user is not the admin of the classroom");
        }
        var member = userRepository.findByEmail(addingUserToClassRoomRequestDTO.getMemberEmail()).orElseThrow();
        if (classRoomRepository.isUserAdminOfClassRoom(classRoomId, member.getId())) {
            throw new ConflictException("user is admin and can't be member");
        }
        var classRoom = classRoomRepository.findById(classRoomId).orElseThrow();
        classRoom.getMembers().add(member);
        classRoomRepository.save(classRoom);
        return new UserAddingToClassRoomStatusResponseDTO(member.getEmail(), "done");
    }

    @Override
    @Transactional
    public List<UserAddingToClassRoomStatusResponseDTO> addMembersToClassRoom(Long classRoomId, List<AddingUserToClassRoomRequestDTO> emails) {
        String email = getCurrentUserEmail();
        var user = userRepository.findByEmail(email).orElseThrow();
        if (!classRoomRepository.isUserAdminOfClassRoom(classRoomId, user.getId())) {
            throw new IllegalArgumentException("you are not the class room owner");
        }
        var classRoom = classRoomRepository.findById(classRoomId).orElseThrow();
        List<UserAddingToClassRoomStatusResponseDTO> res = new ArrayList<>();
        List<User> users = userRepository
                .getUsersByEmails(emails.stream()
                        .map(AddingUserToClassRoomRequestDTO::getMemberEmail)
                        .filter(memberEmail -> !memberEmail.equals(user.getEmail())).toList());
        users.forEach(member -> {
            try {
                classRoom.getMembers().add(member);
                res.add(new UserAddingToClassRoomStatusResponseDTO(member.getEmail(), "done"));
            } catch (Exception ex) {
                res.add(new UserAddingToClassRoomStatusResponseDTO(member.getEmail(), "fail"));
            }
        });
        classRoomRepository.save(classRoom);
        return res;
    }
}
