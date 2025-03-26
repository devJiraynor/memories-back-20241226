package com.sjh.memories_back.common.dto.response.openai;

import java.util.List;

import com.sjh.memories_back.common.vo.GptChoiceVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponseDto {
  private List<GptChoiceVO> choices;
}
