package com.tawfeek.quiz_api.model.classRoom;


import com.tawfeek.quiz_api.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomResponseDTO {

    private Long id;

    private String name;

    private Role role;

    public ClassRoomResponseDTO(Long id,String name){
        this.id=id;
        this.name=name;
    }
}
