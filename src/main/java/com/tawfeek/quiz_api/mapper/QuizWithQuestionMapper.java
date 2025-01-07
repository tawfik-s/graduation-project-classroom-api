package com.tawfeek.quiz_api.mapper;

import com.tawfeek.quiz_api.entity.Quiz;
import com.tawfeek.quiz_api.entity.QuizAnswer;
import com.tawfeek.quiz_api.model.quiz.QuizResponseWithQuestionsDTO;

public interface QuizWithQuestionMapper {
    QuizResponseWithQuestionsDTO toDTO(Quiz quiz);

    QuizResponseWithQuestionsDTO toDTO(Quiz quiz, QuizAnswer quizAnswer);
}
