package com.tawfeek.quiz_api.mapper;

import com.tawfeek.quiz_api.entity.ClassRoom;
import com.tawfeek.quiz_api.model.classRoom.ClassRoomRequestDTO;
import com.tawfeek.quiz_api.model.classRoom.ClassRoomResponseDTO;

public interface ClassRoomMapper {

    public ClassRoomResponseDTO toDTO(ClassRoom classRoom);

    public ClassRoom toEntity(ClassRoomRequestDTO classRoomRequestDTO);
}
