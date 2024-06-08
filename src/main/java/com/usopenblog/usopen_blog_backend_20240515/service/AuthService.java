package com.usopenblog.usopen_blog_backend_20240515.service;

import com.usopenblog.usopen_blog_backend_20240515.dto.request.auth.SignUpRequestDto;
import com.usopenblog.usopen_blog_backend_20240515.dto.response.auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

  ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto Dto);



}
