package com.sjh.memories_back.common.entity;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;

// class: 사용자 지정 OAuth2 유저 객체 //
@Getter
public class CustomOAuth2User implements OAuth2User {

  private String name;
  private Map<String, Object> attributes;
  private Collection<? extends GrantedAuthority> authorities;
  // description: 회원가입 여부 //
  private boolean existed;
  
  public CustomOAuth2User (String name, Map<String, Object> attributes, boolean existed) {
    this.name = name;
    this.attributes = attributes;
    this.authorities = AuthorityUtils.NO_AUTHORITIES;
    this.existed = existed;
  }
}
