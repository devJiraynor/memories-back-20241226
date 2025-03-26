package com.sjh.memories_back.common.entity;

import com.sjh.memories_back.common.entity.pk.EmpathyPk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="empathy")
@Table(name="empathy")
@IdClass(EmpathyPk.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpathyEntity {
  @Id
  private String userId;
  @Id
  private Integer diaryNumber;
}