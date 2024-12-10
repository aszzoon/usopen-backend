package com.usopen.backend.controller;

import com.usopen.backend.dto.request.auth.SignInRequestDto;
import com.usopen.backend.dto.request.auth.SignUpRequestDto;
import com.usopen.backend.dto.response.auth.SignInResponseDto;
import com.usopen.backend.dto.response.auth.SignUpResponseDto;
import com.usopen.backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@ResponseBody가 추가 되었고, json 형태로 객체를 데이터를 반환
@RestController
//특정 url 패턴이나, http 메서드를 처리하는 메서드 정의
@RequestMapping("/api/v1/auth")
// 생성자를 자동으로 생성
@RequiredArgsConstructor
// Controller에는 비즈니스 로직이 구현이 되면 안된다. 서비스 레이어드에 진행을 해야하며, 입력을 받고 검증처리를 하는 구역이다.
public class AuthController {

  //authService 필드 생성, 컨트롤러에서 처리된 요청을 service로 넘기기 위함.
  private final AuthService authService;

  //http post 요청 처리(/sign-up)으로 요청시 호출됨
  @PostMapping("/sign-up")
  public ResponseEntity<? super SignUpResponseDto>
  signUp(@RequestBody @Valid SignUpRequestDto requestBody) {
    ResponseEntity<? super SignUpResponseDto> response
            = authService.signUp(requestBody);
    return response;
  }

  @PostMapping("/sign-in")
  public ResponseEntity<? super SignInResponseDto> signIn(@RequestBody @Valid SignInRequestDto requestBody) {
    ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
    return response;
  }


}
