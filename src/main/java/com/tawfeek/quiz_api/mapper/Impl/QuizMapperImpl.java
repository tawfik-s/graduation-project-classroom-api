package com.tawfeek.quiz_api.mapper.Impl;

import com.tawfeek.quiz_api.entity.Quiz;
import com.tawfeek.quiz_api.mapper.QuizMapper;
import com.tawfeek.quiz_api.model.quiz.QuizRequestDTO;
import com.tawfeek.quiz_api.model.quiz.QuizResponseDTO;
import org.springframework.stereotype.Component;


@Component
public class QuizMapperImpl implements QuizMapper {
    @Override
    public Quiz toEntity(QuizRequestDTO quizRequestDTO) {
        Quiz quiz = new Quiz();
        quiz.setName(quizRequestDTO.getName());
        quiz.setDuration(quizRequestDTO.getDuration());
        quiz.setCreationDateTime(quizRequestDTO.getCreationDateTime());
        quiz.setCloseDate(quizRequestDTO.getCloseDate());
        return quiz;
    }

    @Override
    public QuizResponseDTO toDTO(Quiz quiz) {
        return new QuizResponseDTO(quiz.getId(),
                quiz.getName(),
                quiz.getCreationDateTime(),
                quiz.getDuration(),
                quiz.getCloseDate());
    }
}
