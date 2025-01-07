package com.tawfeek.quiz_api.service;

import com.tawfeek.quiz_api.model.questionAnswer.QuestionAnswerSubmitDTO;
import com.tawfeek.quiz_api.model.quiz.QuizResponseWithQuestionsDTO;
import com.tawfeek.quiz_api.model.quizAnswer.QuizAnswerSubmitDTO;
import com.tawfeek.quiz_api.model.reports.QuizResultReport;
import org.springframework.http.ResponseEntity;

public interface MemberQuizService {

    public QuizResponseWithQuestionsDTO StartTakingTheQuiz(Long classroomId,Long quizId);

    ResponseEntity<String> submitSolution(Long quizId, QuizAnswerSubmitDTO quizAnswerRequestDTO);

    ResponseEntity<String> submitSingleQuestion(Long quizId, Long questionId, QuestionAnswerSubmitDTO questionAnswerSubmitDTO);

    QuizResultReport calculateMyQuizResult(Long quizId);

    ResponseEntity<String> endTheQuiz(Long quizId, QuizAnswerSubmitDTO quizAnswerRequestDTO);
}
