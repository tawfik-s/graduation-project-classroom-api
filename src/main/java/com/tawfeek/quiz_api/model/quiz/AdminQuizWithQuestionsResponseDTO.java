package com.tawfeek.quiz_api.model.quiz;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.tawfeek.quiz_api.model.question.AdminQuestionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminQuizWithQuestionsResponseDTO {
    private Long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date creationDateTime;

    private Long Duration;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date closeDate;

    private List<AdminQuestionResponseDTO> questions;
}
