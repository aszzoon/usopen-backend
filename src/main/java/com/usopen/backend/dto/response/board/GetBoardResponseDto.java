package com.usopen.backend.dto.response.board;

import com.usopen.backend.common.ResponseCode;
import com.usopen.backend.common.ResponseMessage;
import com.usopen.backend.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetBoardResponseDto extends ResponseDto {

  private int boardNumber;
  private String title;
  private String content;
  private List<String> boardImagesList;
  private String writeDatetime;
  private String writerEmail;
  private String writerNickname;
  private String writerProfileImage;

  private GetBoardResponseDto() {
    super(ResponseCode.SUCCESS, ResponseCode.SUCCESS);
  }

  public static ResponseEntity<GetBoardResponseDto> success() {
    GetBoardResponseDto result = new GetBoardResponseDto();
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> notExistBoard() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD); return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
