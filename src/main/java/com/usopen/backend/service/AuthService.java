package com.usopen.backend.service;

import com.usopen.backend.dto.request.auth.SignInRequestDto;
import com.usopen.backend.dto.request.auth.SignUpRequestDto;
import com.usopen.backend.dto.response.auth.SignInResponseDto;
import com.usopen.backend.dto.response.auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

  //signUp : ResponseEntity 반환타입의, wildcard SignUpResponseDto으로 반환. SignUpRequestDto 타입의 Dto 매개변수로 받음
  ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto Dto);

  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto Dto);

  //ResponseEntity<? super UserResponseDto> user(UserRequestDto Dto);
}
