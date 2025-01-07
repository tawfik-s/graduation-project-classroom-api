package com.tawfeek.quiz_api.model.question;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerRequestDTO {

    private Long id;

    private String answer;

}
