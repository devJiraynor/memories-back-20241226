package com.sjh.memories_back.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sjh.memories_back.provider.JwtProvider;
import com.sjh.memories_back.repository.ConcentrationTestRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

// class: JWT Bearer Token 인증 처리를 위한 필터 //
// description: 필터 처리로 인증이 완료되면 접근 주체의 값에는 userId가 주입 //
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtProvider jwtProvider;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    
    try {

      String token = getToken(request);
      if (token == null) {
        filterChain.doFilter(request, response);
        return;
      }

      String userId = jwtProvider.validate(token);
      if (userId == null) {
        filterChain.doFilter(request, response);
        return;
      }

      

    } catch(Exception exception) {
      exception.printStackTrace();
    }

    filterChain.doFilter(request, response);

  }

  // function: Request 객체에서 Token 추출 메서드 //
  private String getToken(HttpServletRequest request) {

    // description: Request 객체에서 Authorization header 값 추출 //
    String authorization = request.getHeader("Authorization");
    boolean hasAuthorization = StringUtils.hasText(authorization);
    if (!hasAuthorization) return null;

    // description: Bearer 인증 방식인지 확인 //
    boolean isBearer = authorization.startsWith("Bearer ");
    if (!isBearer) return null;

    // description: Authorization 필드 값에서 Token 추출 //
    String token = authorization.substring(7);
    return token;

  }
  
}
