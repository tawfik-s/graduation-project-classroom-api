package com.tawfeek.quiz_api.mapper;

import com.tawfeek.quiz_api.entity.Quiz;
import com.tawfeek.quiz_api.model.quiz.QuizRequestDTO;
import com.tawfeek.quiz_api.model.quiz.QuizResponseDTO;

public interface QuizMapper {

    public Quiz toEntity(QuizRequestDTO quizRequestDTO);

    public QuizResponseDTO toDTO(Quiz quiz);
}
