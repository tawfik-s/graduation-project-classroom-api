package com.tawfeek.quiz_api.repository;


import com.tawfeek.quiz_api.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer,Long> {

}
