package com.sjh.memories_back.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="diary")
@Table(name="diary")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiaryEntity {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer diaryNumber;
  private String userId;
  private String writeDate;
  private String weather;
  private String feeling;
  private String title;
  private String content;

}
