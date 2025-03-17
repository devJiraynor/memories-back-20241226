package com.sjh.memories_back.service.implement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.sjh.memories_back.common.entity.CustomOAuth2User;
import com.sjh.memories_back.common.entity.UserEntity;
import com.sjh.memories_back.provider.JwtProvider;
import com.sjh.memories_back.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {

  private final UserRepository userRepository;
  private final JwtProvider jwtProvider;
  
  @Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User oAuth2User = super.loadUser(userRequest);
    String registration = userRequest.getClientRegistration().getClientName().toUpperCase();

    // try {
    //   System.out.println("==================================================");
    //   System.out.println(new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
    //   System.out.println(oAuth2User.getName());
    //   System.out.println("==================================================");
    // } catch (Exception exception) {
    //   exception.printStackTrace();
    // }

    String snsId = getSnsId(oAuth2User, registration);
    UserEntity userEntity = userRepository.findByJoinTypeAndSnsId(registration, snsId);

    CustomOAuth2User customOAuth2User = null;
    Map<String, Object> attributes = new HashMap<>();

    if (userEntity == null) {
      attributes.put("snsId", snsId);
      attributes.put("joinType", registration);

      customOAuth2User = new CustomOAuth2User(snsId, attributes, false);
    } else {
      String userId = userEntity.getUserId();
      String accessToken = jwtProvider.create(userId);
      attributes.put("accessToken", accessToken);

      customOAuth2User = new CustomOAuth2User(userId, attributes, true);
    }

    return customOAuth2User;
  }

  // function: 결과로 받은 유저 정보에서 ragistration에 따라 id 값을 추출하는 함수 //
  private String getSnsId(OAuth2User oAuth2User, String registration) {

    String snsId = null;

    if (registration.equals("KAKAO")) {
      snsId = oAuth2User.getName();
    }
    if (registration.equals("NAVER")) {
      Map<String, String> response = (Map<String, String>) oAuth2User.getAttributes().get("response");
      snsId = response.get("id");
    }

    return snsId;

  }

}
