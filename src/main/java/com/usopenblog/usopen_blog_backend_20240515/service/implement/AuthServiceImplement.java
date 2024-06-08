package com.usopenblog.usopen_blog_backend_20240515.service.implement;

import com.usopenblog.usopen_blog_backend_20240515.dto.request.auth.SignUpRequestDto;
import com.usopenblog.usopen_blog_backend_20240515.dto.response.ResponseDto;
import com.usopenblog.usopen_blog_backend_20240515.dto.response.auth.SignUpResponseDto;
import com.usopenblog.usopen_blog_backend_20240515.entity.UserEntity;
import com.usopenblog.usopen_blog_backend_20240515.repository.UserRepository;
import com.usopenblog.usopen_blog_backend_20240515.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

    try {
      String email = dto.getEmail();
      boolean existsedEmail = userRepository.existsByEmail(email);
      if (existsedEmail) return SignUpResponseDto.duplicateEmail();

      String nickname = dto.getNickname();
      boolean existsedNickname = userRepository.existsByNickname(nickname);
      if (existsedNickname) return SignUpResponseDto.duplicateNickname();

      String telNumber = dto.getTelNumber();
      boolean existsedTelNumber = userRepository.existsByTelNumber(telNumber);
      if (existsedTelNumber) return SignUpResponseDto.duplicateTelNumber();

      String password = dto.getPassword();
      String encodedPassword = passwordEncoder.encode(password);
      dto.setPassword(encodedPassword);

      UserEntity userEntity = new UserEntity(dto);
      userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return SignUpResponseDto.success();
  }
}
