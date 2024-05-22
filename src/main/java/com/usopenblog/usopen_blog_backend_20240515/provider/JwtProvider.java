package com.usopenblog.usopen_blog_backend_20240515.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// bean으로 등록하여 자동으로 관리
@Component
public class JwtProvider {

	@Value("${secret-key}")
	private String secretKey;

	//email을 받아와서 웹토큰 만들기
	public String create(String email) {

		//만료기간 만들기
		Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

		//jwt 생성
		String jwt = Jwts.builder()
						 .signWith(SignatureAlgorithm.ES256, secretKey)
						 .setSubject(email).setIssuedAt(new Date()).setExpiration(expiredDate)
						 .compact();

		return jwt;
	}

	public String validate(String jwt) {

		Claims claims = null;

		try {
			claims = Jwts.parser().setSigningKey(secretKey)
						 .parseClaimsJws(jwt).getBody();
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
		return claims.getSubject();
	}
}
