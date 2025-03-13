package com.sjh.memories_back.common.entity;

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

}
