package com.sjh.memories_back.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.sjh.memories_back.common.entity.ConcentrationTestEntity;

import lombok.Getter;

@Getter
public class ConcentrationTestVO {
  private Integer sequence;
  private Integer measurementScore;
  private Integer errorCount;
  private String testDate;
  private Integer scoreGap;
  private Integer errorGap;

  private ConcentrationTestVO(ConcentrationTestEntity concentrationTestEntity) {
    this.sequence = concentrationTestEntity.getSequence();
    this.measurementScore = concentrationTestEntity.getMeasurementScore();
    this.errorCount = concentrationTestEntity.getErrorCount();
    this.testDate = concentrationTestEntity.getTestDate();
    this.scoreGap = concentrationTestEntity.getScoreGap();
    this.errorGap = concentrationTestEntity.getErrorGap();
  }

  public static List<ConcentrationTestVO> getList(List<ConcentrationTestEntity> concentrationTestEntities) {

    List<ConcentrationTestVO> list = new ArrayList<>();

    for (ConcentrationTestEntity concentrationTestEntity: concentrationTestEntities) {
      ConcentrationTestVO vo = new ConcentrationTestVO(concentrationTestEntity);
      list.add(vo);
    }

    return list;

  }
}
