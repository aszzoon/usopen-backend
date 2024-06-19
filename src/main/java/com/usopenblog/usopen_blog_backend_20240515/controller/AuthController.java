package com.usopenblog.usopen_blog_backend_20240515.controller;

import com.usopenblog.usopen_blog_backend_20240515.dto.request.auth.SignInRequestDto;
import com.usopenblog.usopen_blog_backend_20240515.dto.request.auth.SignUpRequestDto;
import com.usopenblog.usopen_blog_backend_20240515.dto.response.auth.SignInResponseDto;
import com.usopenblog.usopen_blog_backend_20240515.dto.response.auth.SignUpResponseDto;
import com.usopenblog.usopen_blog_backend_20240515.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@ResponseBody가 추가 되었고, json 형태로 객체를 데이터를 반환
@RestController
//
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/sign-up")
  public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody) {
    ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
    return response;
  }

  @PostMapping("/sign-in")
  public ResponseEntity<? super SignInResponseDto> signIn(@RequestBody @Valid SignInRequestDto requestBody) {
    ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
    return response;
  }


}
