package com.tawfeek.quiz_api.model.reports;

import com.tawfeek.quiz_api.model.user.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResultReport {

    private UserResponseDTO userResponseDTO;

    private Long numberOfQuestions;

    private Long numberOfRightQuestion;
}
