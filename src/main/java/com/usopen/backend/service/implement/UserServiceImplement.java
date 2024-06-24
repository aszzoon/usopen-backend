package com.usopen.backend.service.implement;

import com.usopen.backend.dto.response.ResponseDto;
import com.usopen.backend.dto.response.user.SignInUserInfoResponsetDto;
import com.usopen.backend.entity.UserEntity;
import com.usopen.backend.repository.UserRepository;
import com.usopen.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// Service 객체 지정, 제어의 역전을 통해 의존성 주입
@Service
//클래스의 final 필드와 @NonNull 필드에 대한 생성자를 자동으로 생성해주는 역할
@RequiredArgsConstructor
//UserService interface의 구현체
public class UserServiceImplement implements UserService {

  //UserReposotory 필드 선언
  private final UserRepository userRepository;

  // ResponseEntity 메서드 재 정의
  @Override
  // ResponseEntity반환타입의 <SignInUserInfoResponsetDto 부모타입도 허용> SignInUserInfo메서드 (String타입의 email 매개변수)
  public ResponseEntity<? super SignInUserInfoResponsetDto> SignInUserInfo(String email) {

    // null 값 대입
    UserEntity userEntity = null;

    // 예외처리를 위한 try-catch 블록
    try {
      //userEntity에 userRepository.findByEmail(email)을 대입
      userEntity = userRepository.findByEmail(email);
      //만약 userEntity가 null 이면, SignInUserInfoResponsetDto.notExistUser();을 return
      if (userEntity == null) return SignInUserInfoResponsetDto.notExistUser();

    // 위 조건이 아니면 아래 실행, 예외처리
    } catch (Exception exception) {
      //
      exception.printStackTrace();
      // ResponseDto.database 에러 리턴
      return ResponseDto.databaseError();
    }

    //성공 시, SignInUserInfoResponsetDto.success(userEntity) return
    return SignInUserInfoResponsetDto.success(userEntity);
  }
}
