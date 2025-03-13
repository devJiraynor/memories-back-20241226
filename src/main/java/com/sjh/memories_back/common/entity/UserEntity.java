package com.sjh.memories_back.common.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user")
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  
  @Id
  private String userId;
  private String userPassword;
  private String joinType;
  private String snsId;
  private String name;
  private String address;
  private String detailAddress;
  private String profileImage;
  private String gender;
  private Integer age;

}
