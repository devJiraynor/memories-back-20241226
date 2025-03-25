package com.sjh.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.sjh.memories_back.common.dto.request.test.PostConcentrationRequestDto;
import com.sjh.memories_back.common.dto.request.test.PostMemoryRequestDto;
import com.sjh.memories_back.common.dto.response.ResponseDto;
import com.sjh.memories_back.common.dto.response.test.GetConcentrationResponseDto;
import com.sjh.memories_back.common.dto.response.test.GetMemoryResponseDto;
import com.sjh.memories_back.common.dto.response.test.GetRecentlyConcentrationResponseDto;
import com.sjh.memories_back.common.dto.response.test.GetRecentlyMemoryResponseDto;

public interface TestService {
  ResponseEntity<ResponseDto> postMemory(PostMemoryRequestDto dto, String userId);
  ResponseEntity<ResponseDto> postConcentration(PostConcentrationRequestDto dto, String userId);
  ResponseEntity<? super GetMemoryResponseDto> getMemory(String userId);
  ResponseEntity<? super GetConcentrationResponseDto> getConcentration(String userId);
  ResponseEntity<? super GetRecentlyMemoryResponseDto> getRecentlyMemory(String userId);
  ResponseEntity<? super GetRecentlyConcentrationResponseDto> getRecentlyConcentration(String userId);
}
