package com.sjh.memories_back.common.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.sjh.memories_back.common.dto.request.test.PostConcentrationRequestDto;
import com.sjh.memories_back.common.entity.pk.ConcentrationTestPk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="concentrationTest")
@Table(name="concentration_test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ConcentrationTestPk.class)
public class ConcentrationTestEntity {
  @Id
  private String userId;
  @Id
  private Integer sequence;
  private Integer measurementScore;
  private Integer errorCount;
  private String testDate;
  private Integer scoreGap;
  private Integer errorGap;

  public ConcentrationTestEntity(PostConcentrationRequestDto dto, String userId) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    this.userId = userId;
    this.sequence = 1;
    this.measurementScore = dto.getMeasurementScore();
    this.errorCount = dto.getErrorCount();
    this.testDate = now.format(dateTimeFormatter);
  }

  public ConcentrationTestEntity(PostConcentrationRequestDto dto, ConcentrationTestEntity preEntity, String userId) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    this.userId = userId;
    this.sequence = preEntity.getSequence() + 1;
    this.measurementScore = dto.getMeasurementScore();
    this.errorCount = dto.getErrorCount();
    this.testDate = now.format(dateTimeFormatter);
    this.scoreGap = dto.getMeasurementScore() - preEntity.getMeasurementScore();
    this.errorCount = dto.getErrorCount() - preEntity.getErrorCount();
  }
}
