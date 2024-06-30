package com.usopen.backend.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// IoC를 위한 DI를 하기 위해 bean으로 등록하여 자동으로 관리
@Component
public class JwtProvider {

  @Value("${secretKey}")
  private String secretKey;

  //email을 받아와서 웹토큰 만들기
  public String create(String email) {
    System.out.println("secretkey");
    //Json 만료기간 만들기
    Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
    Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    //jwt 생성
    String jwt = Jwts.builder()
            .signWith(key, SignatureAlgorithm.HS256)
            .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
            .compact();

    return jwt;
  }

  public String validate(String jwt) {
    Claims claims = null;
    Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    try {
      claims = Jwts.parserBuilder()
              .setSigningKey(key)
              .build()
              .parseClaimsJws(jwt)
              .getBody();
    } catch (Exception exception) {
      // 예외 처리: 유효하지 않은 JWT 처리
      // 예를 들어, 로그를 남기거나 특정 오류 메시지를 반환할 수 있음
      exception.printStackTrace(); // 예제로는 출력만 하지만, 실제로는 적절한 처리가 필요함
      return null;
    }

    return claims.getSubject();
  }

}
