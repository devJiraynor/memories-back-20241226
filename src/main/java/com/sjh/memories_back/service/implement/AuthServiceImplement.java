package com.sjh.memories_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sjh.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.sjh.memories_back.common.dto.request.auth.SignInRequestDto;
import com.sjh.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.sjh.memories_back.common.dto.response.ResponseDto;
import com.sjh.memories_back.common.dto.response.auth.SignInResponseDto;
import com.sjh.memories_back.common.entity.UserEntity;
import com.sjh.memories_back.provider.JwtProvider;
import com.sjh.memories_back.repository.UserRepository;
import com.sjh.memories_back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

  private final UserRepository userRepository;
  private final JwtProvider jwtProvider;
  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {
    
    try {

      String userId = dto.getUserId();
      boolean existUser = userRepository.existsByUserId(userId);
      if (existUser) return ResponseDto.existUser();

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
    
    try {

      String userId = dto.getUserId();
      boolean existUser = userRepository.existsByUserId(userId);
      if (existUser) return ResponseDto.existUser();

      String userPassword = dto.getUserPassword();
      String encodedPassword = passwordEncoder.encode(userPassword);
      dto.setUserPassword(encodedPassword);

      UserEntity userEntity = new UserEntity(dto);
      userRepository.save(userEntity);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.CREATED);

  }

  @Override
  public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
    
    String accessToken = null;

    try {

      String userId = dto.getUserId();
      UserEntity userEntity = userRepository.findByUserId(userId);
      if (userEntity == null) return ResponseDto.signInFail();

      String userPassword = dto.getUserPassword();
      String encodedPassword = userEntity.getUserPassword();
      boolean isMatch = passwordEncoder.matches(userPassword, encodedPassword);
      if (!isMatch) return ResponseDto.signInFail();

      accessToken = jwtProvider.create(userId);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return SignInResponseDto.success(accessToken);

  }
  
}
