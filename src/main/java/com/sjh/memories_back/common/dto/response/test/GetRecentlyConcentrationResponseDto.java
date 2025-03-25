package com.sjh.memories_back.common.dto.response.test;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sjh.memories_back.common.dto.response.ResponseDto;
import com.sjh.memories_back.common.entity.ConcentrationTestEntity;
import com.sjh.memories_back.common.vo.ConcentrationTestVO;

import lombok.Getter;

@Getter
public class GetRecentlyConcentrationResponseDto extends ResponseDto {

  private List<ConcentrationTestVO> concentrationTests;

  private GetRecentlyConcentrationResponseDto(
    List<ConcentrationTestEntity> concentrationTestEntities
  ) {
    this.concentrationTests = ConcentrationTestVO.getList(concentrationTestEntities);
  }

  public static ResponseEntity<GetRecentlyConcentrationResponseDto> success(
    List<ConcentrationTestEntity> concentrationTestEntities
  ) {
    GetRecentlyConcentrationResponseDto body = new GetRecentlyConcentrationResponseDto(concentrationTestEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
