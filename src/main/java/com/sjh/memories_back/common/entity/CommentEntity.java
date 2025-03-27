package com.sjh.memories_back.common.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.sjh.memories_back.common.dto.request.diary.PostCommentRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="comment")
@Table(name="comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer commentNumber;
  private String userId;
  private Integer diaryNumber;
  private String writeDate;
  private String content;

  public CommentEntity(PostCommentRequestDto dto, Integer diaryNumber, String userId) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    this.userId = userId;
    this.diaryNumber = diaryNumber;
    this.writeDate = now.format(dateTimeFormatter);
    this.content = dto.getComment();
  }
}
