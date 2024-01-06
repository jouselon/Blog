package com.blog.boardback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry corsRegistry) {
    corsRegistry
        .addMapping("/**") // 모든 경로에 대해 CORS를 활성화
        .allowedMethods("*") //모든 HTTP 메서드를 허용
        .allowedOrigins("*"); //모든 오리진(출처)에 대해 CORS를 허용

  }

}