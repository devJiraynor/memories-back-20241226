package com.sjh.memories_back.common.dto.response.openai;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sjh.memories_back.common.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetWayResponseDto extends ResponseDto {
  private String result;

  private GetWayResponseDto(String result) {
    this.result = result;
  }

  public static ResponseEntity<GetWayResponseDto> success(String result) {
    GetWayResponseDto body = new GetWayResponseDto(result);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
