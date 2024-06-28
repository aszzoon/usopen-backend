package com.usopen.backend.dto.response.board;

import com.usopen.backend.common.ResponseCode;
import com.usopen.backend.common.ResponseMessage;
import com.usopen.backend.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostBoardResponseDto extends ResponseDto {

  private PostBoardResponseDto(){
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
  }

  public static ResponseEntity<PostBoardResponseDto> success() {
    PostBoardResponseDto result = new PostBoardResponseDto();
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> notExistUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
  }
}
