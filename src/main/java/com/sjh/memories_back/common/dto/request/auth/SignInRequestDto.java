package com.sjh.memories_back.common.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequestDto {
  @NotBlank
  private String userId;
  @NotBlank
  private String userPassword;
}
