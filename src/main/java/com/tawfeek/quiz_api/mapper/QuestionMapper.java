package com.tawfeek.quiz_api.mapper;

import com.tawfeek.quiz_api.entity.Question;
import com.tawfeek.quiz_api.entity.QuestionAnswer;
import com.tawfeek.quiz_api.model.question.QuestionResponseDTO;

public interface QuestionMapper {

    public QuestionResponseDTO toDTO(Question question);

    public QuestionResponseDTO toDTO(Question question, QuestionAnswer questionAnswer);
}
