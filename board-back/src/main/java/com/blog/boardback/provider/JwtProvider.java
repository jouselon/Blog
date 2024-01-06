package com.blog.boardback.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtProvider {

  @Value("${secret-key}") //application.properties 확인
  private String secretKey = "S3cr3tK3y";

  public String create(String email){

    // 토큰의 만료 날짜를 현재 시간으로부터 1시간 후로 설정 // java.util
    Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

    // 이메일을 주제로, 현재 시간을 발행 시간으로, 계산된 만료 날짜로 하는 JWT 토큰을 생성. // JWT 토큰을 빌드하고 반환
    String jwt = Jwts.builder()
        .signWith(SignatureAlgorithm.HS256, secretKey)  // HMAC SHA-256을 사용하여 서명
        .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
        .compact();

    // 생성된 JWT 토큰 반환
    return jwt;
  }

  // JWT 토큰을 유효성 검사하고 주제(Subject)를 추출하는 메서드
  public String validate(String jwt) {

    Claims claims = null;

    try {
      // 주어진 JWT 토큰을 해석하고 클레임(claim)을 추출
      claims = Jwts.parser().setSigningKey(secretKey)
          .parseClaimsJws(jwt).getBody();
    } catch (Exception exception) {
      // 예외가 발생하면 스택 트레이스를 출력하고 null을 반환
      exception.printStackTrace();
      return null;
    }

    // 추출된 주제 반환
    return claims.getSubject();
  }
}
