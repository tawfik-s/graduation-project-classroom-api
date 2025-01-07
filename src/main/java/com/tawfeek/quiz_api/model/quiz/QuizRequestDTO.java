package com.tawfeek.quiz_api.model.quiz;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizRequestDTO {

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date creationDateTime;

    private Long Duration;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date closeDate;

}
