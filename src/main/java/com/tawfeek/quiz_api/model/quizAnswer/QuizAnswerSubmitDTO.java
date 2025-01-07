package com.tawfeek.quiz_api.model.quizAnswer;


import com.tawfeek.quiz_api.model.questionAnswer.QuestionAnswerSubmitDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAnswerSubmitDTO {
    private List<QuestionAnswerSubmitDTO> questionsAnswerList;
}
