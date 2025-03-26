package com.sjh.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.sjh.memories_back.common.dto.request.openai.GetWayRequestDto;
import com.sjh.memories_back.common.dto.response.openai.GetWayResponseDto;

public interface OpenAIService {
  ResponseEntity<? super GetWayResponseDto> getWay(GetWayRequestDto dto, String userId);
}
