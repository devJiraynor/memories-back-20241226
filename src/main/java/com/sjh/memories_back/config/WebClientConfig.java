package com.sjh.memories_back.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
  
  @Value("${openai.api.key}")
  private String openAIKey;

  @Bean
  public WebClient openAiWebClient() {
    
    return WebClient.builder()
      .baseUrl("https://api.openai.com/v1")
      .defaultHeader("Content-Type", "application/json")
      .defaultHeader("Authorization", "Bearer " + openAIKey)
      .build();

  }

}
