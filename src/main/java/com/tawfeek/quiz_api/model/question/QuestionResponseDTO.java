package com.tawfeek.quiz_api.model.question;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDTO {
    private Long id;

    private String text;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String lastAnswer;
}
