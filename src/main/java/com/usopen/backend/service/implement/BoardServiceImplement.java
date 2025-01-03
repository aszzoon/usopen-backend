package com.usopen.backend.service.implement;

import com.usopen.backend.dto.request.board.PostBoardRequestDto;
import com.usopen.backend.dto.response.ResponseDto;
import com.usopen.backend.dto.response.board.GetBoardResponseDto;
import com.usopen.backend.dto.response.board.PostBoardResponseDto;
import com.usopen.backend.repository.BoardRepository;
import com.usopen.backend.repository.ImageRepository;
import com.usopen.backend.repository.UserRepository;
import com.usopen.backend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

  private final BoardRepository boardRepository;
  private final ImageRepository imageRepository;
  private final UserRepository userRepository;

  @Override
  public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email) {

    try {


    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return PostBoardResponseDto.success();
  }

  @Override
  public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
    return null;
  }

}
