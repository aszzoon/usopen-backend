package com.usopen.backend.controller;

import com.usopen.backend.dto.response.user.SignInUserInfoResponsetDto;
import com.usopen.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("")
  public ResponseEntity<? super SignInUserInfoResponsetDto> SingInUserInfo(@AuthenticationPrincipal String email) {
    ResponseEntity<? super SignInUserInfoResponsetDto> response = userService.SignInUserInfo(email);
    return response;
  }
}
