package com.sjh.memories_back.common.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

  @NotBlank
  @Pattern(regexp="^[a-zA-Z0-9]{6,20}$")
  private String userId;

  @NotBlank
  @Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,13}$")
  private String userPassword;

  @NotBlank
  @Pattern(regexp="^[가-힣]{2,5}$")
  private String name;

  @NotBlank
  private String address;

  private String detailAddress;
  
  @NotBlank
  @Pattern(regexp="^(NORMAL|KAKAO|NAVER)$")
  private String joinType;

  private String snsId;

}
