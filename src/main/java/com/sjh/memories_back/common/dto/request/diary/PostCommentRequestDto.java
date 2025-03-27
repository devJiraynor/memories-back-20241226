package com.sjh.memories_back.common.dto.request.diary;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentRequestDto {
  @NotBlank
  private String comment;
}
