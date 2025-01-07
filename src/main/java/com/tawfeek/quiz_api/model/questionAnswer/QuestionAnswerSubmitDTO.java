package com.tawfeek.quiz_api.model.questionAnswer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerSubmitDTO {
    private long id;
    private String answer;
}
