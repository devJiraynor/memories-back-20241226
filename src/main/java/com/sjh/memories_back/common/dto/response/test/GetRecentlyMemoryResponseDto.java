package com.sjh.memories_back.common.dto.response.test;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sjh.memories_back.common.dto.response.ResponseDto;
import com.sjh.memories_back.common.entity.MemoryTestEntity;
import com.sjh.memories_back.common.vo.MemoryTestVO;

import lombok.Getter;

@Getter
public class GetRecentlyMemoryResponseDto extends ResponseDto {
  
  private List<MemoryTestVO> memoryTests;

  private GetRecentlyMemoryResponseDto(List<MemoryTestEntity> memoryTestEntities) {
    this.memoryTests = MemoryTestVO.getList(memoryTestEntities);
  }

  public static ResponseEntity<GetRecentlyMemoryResponseDto> success(List<MemoryTestEntity> memoryTestEntities) {
    GetRecentlyMemoryResponseDto body = new GetRecentlyMemoryResponseDto(memoryTestEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }

}
