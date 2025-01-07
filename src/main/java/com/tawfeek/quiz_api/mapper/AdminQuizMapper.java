package com.tawfeek.quiz_api.mapper;

import com.tawfeek.quiz_api.entity.Quiz;
import com.tawfeek.quiz_api.model.quiz.AdminQuizWithQuestionRequestDTO;
import com.tawfeek.quiz_api.model.quiz.AdminQuizWithQuestionsResponseDTO;

public interface AdminQuizMapper {

  public AdminQuizWithQuestionsResponseDTO toDTO(Quiz quiz);

  public Quiz toEntity(
          AdminQuizWithQuestionRequestDTO quizCreationWithQuestionsDTO);
}
