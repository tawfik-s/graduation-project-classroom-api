package com.tawfeek.quiz_api.model.quizScore;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tawfeek.quiz_api.model.user.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizScoreResponseDTO {

    private Long id;

    private UserResponseDTO userResponseDTO;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date submtionDate;

    private Long Score;

}
