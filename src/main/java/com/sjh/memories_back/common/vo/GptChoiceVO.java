package com.sjh.memories_back.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GptChoiceVO {
  private int index;
  private GptMessageVO message;
  private String finish_reason;
}
