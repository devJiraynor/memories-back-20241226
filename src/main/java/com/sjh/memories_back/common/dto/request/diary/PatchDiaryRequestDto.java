package com.sjh.memories_back.common.dto.request.diary;

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
public class PatchDiaryRequestDto {
  @NotBlank
  @Pattern(regexp="^맑음|흐림|비|눈|안개$")
  private String weather;
  @NotBlank
  @Pattern(regexp="^행복|즐거움|보통|슬픔|분노$")
  private String feeling;
  @NotBlank
  private String title;
  @NotBlank
  private String content;
}
