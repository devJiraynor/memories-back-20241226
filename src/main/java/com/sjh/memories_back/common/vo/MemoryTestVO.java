package com.sjh.memories_back.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.sjh.memories_back.common.entity.MemoryTestEntity;

import lombok.Getter;

@Getter
public class MemoryTestVO {
  private Integer sequence;
  private Integer measurementTime;
  private String testDate;
  private Integer gap;

  private MemoryTestVO(MemoryTestEntity memoryTestEntity) {
    this.sequence = memoryTestEntity.getSequence();
    this.measurementTime = memoryTestEntity.getMeasurementTime();
    this.testDate = memoryTestEntity.getTestDate();
    this.gap = memoryTestEntity.getGap();
  }

  public static List<MemoryTestVO> getList(List<MemoryTestEntity> memoryTestEntities) {
    List<MemoryTestVO> list = new ArrayList<>();

    for (MemoryTestEntity memoryTestEntity: memoryTestEntities) {
      MemoryTestVO vo = new MemoryTestVO(memoryTestEntity);
      list.add(vo);
    }

    return list;
  }
}
