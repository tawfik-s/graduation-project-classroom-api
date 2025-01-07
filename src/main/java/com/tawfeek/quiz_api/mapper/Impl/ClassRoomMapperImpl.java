package com.tawfeek.quiz_api.mapper.Impl;

import com.tawfeek.quiz_api.entity.ClassRoom;
import com.tawfeek.quiz_api.mapper.ClassRoomMapper;
import com.tawfeek.quiz_api.model.classRoom.ClassRoomRequestDTO;
import com.tawfeek.quiz_api.model.classRoom.ClassRoomResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ClassRoomMapperImpl implements ClassRoomMapper {


    @Override
    public ClassRoomResponseDTO toDTO(ClassRoom classRoom) {
        return new ClassRoomResponseDTO(classRoom.getId(),classRoom.getName());
    }

    @Override
    public ClassRoom toEntity(ClassRoomRequestDTO classRoomRequestDTO) {
        return new ClassRoom(classRoomRequestDTO.getName());
    }
}
