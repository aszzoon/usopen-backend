package com.usopen.backend.service.implement;

import com.usopen.backend.dto.request.auth.SignInRequestDto;
import com.usopen.backend.dto.request.auth.SignUpRequestDto;
import com.usopen.backend.dto.response.ResponseDto;
import com.usopen.backend.dto.response.auth.SignInResponseDto;
import com.usopen.backend.dto.response.auth.SignUpResponseDto;
import com.usopen.backend.entity.UserEntity;
import com.usopen.backend.provider.JwtProvider;
import com.usopen.backend.repository.UserRepository;
import com.usopen.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// Service 객체 지정, 제어의 역전을 통해 의존성 주입
@Service
//클래스의 final 필드와 @NonNull 필드에 대한 생성자를 자동으로 생성해주는 역할
@RequiredArgsConstructor
//AuthService interface의 구현체
public class AuthServiceImplement implements AuthService {

  //DB에 작업을 하려면, Repository(저장소)를 가져와야 한다.
  private final UserRepository userRepository;
  //
  private final JwtProvider jwtProvider;

  //내부에서 주입
  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  //@Override 하여, service interface를 구현
  @Override
  public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

    //예외 처리를 위한 try catch, 중복될수 없는 data를 확인
    try {
      //dto에서 Email을 가져와 String email에 대입
      String email = dto.getEmail();
      //userRepository.existsByEmail(email);이 참일 경우, boolean existsedEmail에 대입
      boolean existsedEmail = userRepository.existsByEmail(email);
      // existsedEmail 존재한다면, SignUpResponseDto.duplicateEmail(); 리턴
      if (existsedEmail) return SignUpResponseDto.duplicateEmail();

      String nickname = dto.getNickname();
      boolean existsedNickname = userRepository.existsByNickname(nickname);
      if (existsedNickname) return SignUpResponseDto.duplicateNickname();

      String telNumber = dto.getTelNumber();
      boolean existsedTelNumber = userRepository.existsByTelNumber(telNumber);
      if (existsedTelNumber) return SignUpResponseDto.duplicateTelNumber();

      //암호화가 되어있지 않은 패스워드를 가져오게됨
      String password = dto.getPassword();
      //spring-security passwordEncoder를 사용하여 암호화
      String encodedPassword = passwordEncoder.encode(password);
      // 암호화 된 패스워드를 다시 dto에 반환
      dto.setPassword(encodedPassword);

      //보통 builder 를 사용할수 있으나, 다른 방식으로 구현
      UserEntity userEntity = new UserEntity(dto);
      userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    //성공시 SignUpResponseDto.success 리턴
    return SignUpResponseDto.success();
  }

  @Override
  public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
    String token = null;

    try {
      String email = dto.getEmail();
      UserEntity userEntity = userRepository.findByEmail(email);
      if (userEntity == null) return SignInResponseDto.signInFailed();

      String password = dto.getPassword();
      String encodedPassword = userEntity.getPassword();
      boolean isMatched = passwordEncoder.matches(password, encodedPassword);
      if (!isMatched) return SignInResponseDto.signInFailed();

      token = jwtProvider.create(email);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return SignInResponseDto.success(token);
  }

  @Override
  public ResponseEntity<? super UserResponseDto> User(UserRequestDto dto) {

  }
}







