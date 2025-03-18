package com.sjh.memories_back.handler;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sjh.memories_back.common.entity.CustomOAuth2User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// class: OAuth2 유저 서비스 작업이 성공했을 때 처리를 담당하는 클래스 //
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Value("${oauth.client-main}")
  private String oAuthClientMain;
  @Value("${oauth.client-auth}")
  private String oAuthClientAuth;
  
  @Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
    Map<String, Object> attributes = oAuth2User.getAttributes();
    boolean existed = oAuth2User.isExisted();

    // description: 회원가입 O //
    if (existed) {
      String accessToken = (String) attributes.get("accessToken");
      Cookie cookie = new Cookie("accessToken", accessToken);
      cookie.setPath("/");
      cookie.setHttpOnly(false);
      cookie.setMaxAge(60 * 60 * 9);

      response.addCookie(cookie);
      response.sendRedirect(oAuthClientMain);
    }
    // description: 회원가입 X //
    else {
      String snsId = (String) attributes.get("snsId");
      Cookie snsIdCookie = new Cookie("snsId", snsId);
      snsIdCookie.setPath("/");
      snsIdCookie.setHttpOnly(false);
      snsIdCookie.setMaxAge(60 * 60);

      response.addCookie(snsIdCookie);
      
      String joinType = (String) attributes.get("joinType");
      Cookie joinTypeCookie = new Cookie("joinType", joinType);
      joinTypeCookie.setPath("/");
      joinTypeCookie.setHttpOnly(false);
      joinTypeCookie.setMaxAge(60 * 60);
      
      response.addCookie(joinTypeCookie);

      response.sendRedirect(oAuthClientAuth);
    }
  }

}
