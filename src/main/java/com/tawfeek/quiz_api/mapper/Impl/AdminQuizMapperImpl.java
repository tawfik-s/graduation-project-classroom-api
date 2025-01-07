package com.tawfeek.quiz_api.mapper.Impl;

import com.tawfeek.quiz_api.entity.Quiz;
import com.tawfeek.quiz_api.mapper.AdminQuestionMapper;
import com.tawfeek.quiz_api.mapper.AdminQuizMapper;
import com.tawfeek.quiz_api.model.quiz.AdminQuizWithQuestionRequestDTO;
import com.tawfeek.quiz_api.model.quiz.AdminQuizWithQuestionsResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminQuizMapperImpl implements AdminQuizMapper {

  @Autowired AdminQuestionMapper adminQuestionMapper;

  @Override
  public AdminQuizWithQuestionsResponseDTO toDTO(Quiz quiz) {
    AdminQuizWithQuestionsResponseDTO quizResponse =
        new AdminQuizWithQuestionsResponseDTO();
    quizResponse.setName(quiz.getName());
    quizResponse.setDuration(quiz.getDuration());
    quizResponse.setId(quiz.getId());
    quizResponse.setCloseDate(quiz.getCloseDate());
    quizResponse.setCreationDateTime(quiz.getCreationDateTime());
    quizResponse.setQuestions(
        quiz.getQuestions().stream().map(question -> adminQuestionMapper.toDTO(question)).toList());
    return quizResponse;
  }

  @Override
  public Quiz toEntity(AdminQuizWithQuestionRequestDTO quizRequest) {
    Quiz quiz = new Quiz();
    quiz.setName(quizRequest.getName());
    quiz.setDuration(quizRequest.getDuration());
    quiz.setCreationDateTime(quizRequest.getCreationDateTime());
    quiz.setCloseDate(quizRequest.getCloseDate());
    return quiz;
  }
}
