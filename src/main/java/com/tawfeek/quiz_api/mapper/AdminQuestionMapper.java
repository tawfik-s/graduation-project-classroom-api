package com.tawfeek.quiz_api.mapper;

import com.tawfeek.quiz_api.entity.Question;
import com.tawfeek.quiz_api.model.question.AdminQuestionRequestDTO;
import com.tawfeek.quiz_api.model.question.AdminQuestionResponseDTO;

public interface AdminQuestionMapper {
  public AdminQuestionResponseDTO toDTO(Question question);

  public Question toEntity(AdminQuestionRequestDTO adminQuestionRequestDTO);
}
