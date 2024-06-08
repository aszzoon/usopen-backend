package com.usopenblog.usopen_blog_backend_20240515.controller;

import com.usopenblog.usopen_blog_backend_20240515.dto.request.auth.SignUpRequestDto;
import com.usopenblog.usopen_blog_backend_20240515.dto.response.auth.SignUpResponseDto;
import com.usopenblog.usopen_blog_backend_20240515.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/sign=up")
  public ResponseEntity<? super SignUpResponseDto> signUp(
          @RequestBody @Valid SignUpRequestDto requestBody
  ) {
    ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
    return response;
  }
}
