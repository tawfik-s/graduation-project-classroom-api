package com.tawfeek.quiz_api.mapper.Impl;

import com.tawfeek.quiz_api.entity.QuestionAnswer;
import com.tawfeek.quiz_api.entity.Quiz;
import com.tawfeek.quiz_api.entity.QuizAnswer;
import com.tawfeek.quiz_api.mapper.QuestionMapper;
import com.tawfeek.quiz_api.mapper.QuizWithQuestionMapper;
import com.tawfeek.quiz_api.model.quiz.QuizResponseWithQuestionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class QuizWithQuestionMapperImpl implements QuizWithQuestionMapper {
  @Autowired private QuestionMapper questionMapper;

  @Override
  public QuizResponseWithQuestionsDTO toDTO(Quiz quiz) {
    QuizResponseWithQuestionsDTO quizResponseDTO = new QuizResponseWithQuestionsDTO();
    quizResponseDTO.setId(quiz.getId());
    quizResponseDTO.setName(quiz.getName());
    quizResponseDTO.setDuration(quiz.getDuration());
    quizResponseDTO.setCreationDateTime(quiz.getCreationDateTime());
    quizResponseDTO.setCloseDate(quiz.getCloseDate());
    quizResponseDTO.setQuestions(
        quiz.getQuestions().stream().map(question -> questionMapper.toDTO(question)).toList());
    return quizResponseDTO;
  }

  @Override
  public QuizResponseWithQuestionsDTO toDTO(Quiz quiz, QuizAnswer quizAnswer) {
    QuizResponseWithQuestionsDTO quizResponseDTO = new QuizResponseWithQuestionsDTO();
    quizResponseDTO.setId(quiz.getId());
    quizResponseDTO.setName(quiz.getName());
    quizResponseDTO.setDuration(quiz.getDuration());
    quizResponseDTO.setCreationDateTime(quiz.getCreationDateTime());
    quizResponseDTO.setCloseDate(quiz.getCloseDate());
    quizResponseDTO.setQuestions(
        quiz.getQuestions().stream()
            .map(
                question ->
                    questionMapper.toDTO(
                        question,
                        quizAnswer.getQuestionAnswers().stream()
                            .filter(
                                questionAnswer ->
                                        Objects.equals(questionAnswer.getQuestion().getId(), question.getId()))
                            .findFirst()
                            .orElse(new QuestionAnswer())))
            .toList());
    return quizResponseDTO;
  }
}
