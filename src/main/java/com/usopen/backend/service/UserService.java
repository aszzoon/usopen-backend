package com.usopen.backend.service;

import com.usopen.backend.dto.response.user.SignInUserInfoResponsetDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

ResponseEntity< ? super SignInUserInfoResponsetDto> SignInUserInfo(String email);

}
