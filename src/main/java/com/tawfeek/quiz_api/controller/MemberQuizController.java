package com.tawfeek.quiz_api.controller;

import com.tawfeek.quiz_api.model.questionAnswer.QuestionAnswerSubmitDTO;
import com.tawfeek.quiz_api.model.quiz.QuizResponseWithQuestionsDTO;
import com.tawfeek.quiz_api.model.quizAnswer.QuizAnswerSubmitDTO;
import com.tawfeek.quiz_api.model.reports.QuizResultReport;
import com.tawfeek.quiz_api.service.MemberQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classrooms")
public class MemberQuizController {

  @Autowired private MemberQuizService memberQuizService;

  @PostMapping("/{classroomId}/quizzes/{quizId}/take")
  public QuizResponseWithQuestionsDTO takeQuiz(
      @PathVariable Long classroomId, @PathVariable Long quizId) {
    return memberQuizService.StartTakingTheQuiz(classroomId, quizId);
  }

  @PostMapping("/quizzes/{quizId}/submit")
  public ResponseEntity<String> submitQuizAnswers(
      @PathVariable Long quizId, @RequestBody QuizAnswerSubmitDTO quizAnswerRequestDTO) {
    return memberQuizService.submitSolution(quizId, quizAnswerRequestDTO);
  }

  @PostMapping("/quizzes/{quizId}/submit/{questionId}")
  public ResponseEntity<String> submitQuestionAnswer(
      @PathVariable Long quizId,
      @PathVariable Long questionId,
      @RequestBody QuestionAnswerSubmitDTO questionAnswerSubmitDTO) {
    return memberQuizService.submitSingleQuestion(quizId, questionId, questionAnswerSubmitDTO);
  }

  @PostMapping("/quizzes/{quizId}/end")
  public ResponseEntity<String> endExam(
      @PathVariable Long quizId, @RequestBody QuizAnswerSubmitDTO quizAnswerRequestDTO) {

    return memberQuizService.endTheQuiz(quizId, quizAnswerRequestDTO);
  }

  @GetMapping("/quizzes/{quizId}/calculate-results")
  public QuizResultReport calculateMyExamResults(@PathVariable Long quizId) {
    return memberQuizService.calculateMyQuizResult(quizId);
  }
}
