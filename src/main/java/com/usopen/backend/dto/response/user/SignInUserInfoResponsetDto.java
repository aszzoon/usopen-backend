package com.usopen.backend.dto.response.user;

import com.usopen.backend.common.ResponseCode;
import com.usopen.backend.common.ResponseMessage;
import com.usopen.backend.dto.response.ResponseDto;
import com.usopen.backend.entity.UserEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
//SignInUserInfoResponsetDto 클래스는 ResponseDto 클래스를 상속 받는다.
public class SignInUserInfoResponsetDto extends ResponseDto {

  //필드 선언
  private String email;
  private String nickname;
  private String profileImage;

  //SignInUserInfoResponsetDto 생성자. UserEntity 객체를 매개변수로 받는다.
  private SignInUserInfoResponsetDto(UserEntity userEntity) {
    // 상속받는 부모클래스인 ResponseDto의 생성자를 호출 하여, 응답코드를 SUCCESS로 설정
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    // UserEntity 객체로부터 값을 가져와 필드에 할당
    this.email = userEntity.getEmail();
    this.nickname = userEntity.getNickname();
    this.profileImage = userEntity.getProfileImage();
  }

  //RespnseEntuty 클래스를 반환타입으로 받아 seccess 메소드를 구현. UserEntity타입의 userEntity 매개변수를 받는다.
  public static ResponseEntity<SignInUserInfoResponsetDto> success(UserEntity userEntity) {
    //SignInUserInfoResponsetDto 객체를 생성
    SignInUserInfoResponsetDto result = new SignInUserInfoResponsetDto(userEntity);
    // ResponseEntity를 생성하여 HTTP 상태 코드 200(OK)와 함께 반환
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  //
  public static ResponseEntity<ResponseDto> notExistUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
  }






}
