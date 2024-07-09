package com.usopen.backend.dto.response.board;

import com.usopen.backend.common.ResponseCode;
import com.usopen.backend.dto.response.ResponseDto;
import lombok.Getter;

import java.util.List;

@Getter
public class GetBoardResponseDto extends ResponseDto {

  private int boardNumber;
  private String title;
  private String content;
  private List<String> boardImagesList;
  private String writerEmail;
  private String writerNickname;
  private String writerProfileImage;

  private GetBoardResponseDto() {
    super(ResponseCode.SUCCESS, ResponseCode.SUCCESS);
  }

}
