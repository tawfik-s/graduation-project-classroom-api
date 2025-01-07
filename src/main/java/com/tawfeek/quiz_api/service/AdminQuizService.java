package com.tawfeek.quiz_api.service;

import com.tawfeek.quiz_api.model.question.AdminQuestionRequestDTO;
import com.tawfeek.quiz_api.model.quiz.AdminQuizWithQuestionRequestDTO;
import com.tawfeek.quiz_api.model.quiz.QuizRequestDTO;
import com.tawfeek.quiz_api.model.quiz.QuizResponseDTO;
import com.tawfeek.quiz_api.model.quiz.AdminQuizWithQuestionsResponseDTO;
import com.tawfeek.quiz_api.model.reports.QuizResultReport;

import java.util.List;

public interface AdminQuizService {

  QuizResponseDTO createQuiz(Long classroomId, QuizRequestDTO quizRequestDTO);

  List<QuizResponseDTO> getClassroomQuizzes(Long classroomId);

  AdminQuizWithQuestionsResponseDTO addQuestion(
      long classroomId, long quizId, AdminQuestionRequestDTO questionRequest);

  AdminQuizWithQuestionsResponseDTO createQuizWithQuestions(
      Long classroomId, AdminQuizWithQuestionRequestDTO quizRequest);

  void deleteQuiz(Long classroomId, Long quizId);

  void deleteQuestion(Long classroomId, Long quizId, Long questionId);

  AdminQuizWithQuestionsResponseDTO updateQuiz(
      Long classroomId, Long quizId, QuizRequestDTO quizRequestDTO);

  AdminQuizWithQuestionsResponseDTO getQuizWithQuestionsById(Long classroomId, Long quizId);

  AdminQuizWithQuestionsResponseDTO updateQuestion(
      Long classroomId,
      Long quizId,
      Long questionId,
      AdminQuestionRequestDTO adminQuestionRequestDTO);

    List<QuizResultReport> calculateQuizResult(Long classroomId,Long quizId);
}
