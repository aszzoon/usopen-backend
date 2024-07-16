package com.usopen.backend.service;

import com.usopen.backend.dto.request.board.PostBoardRequestDto;
import com.usopen.backend.dto.response.board.GetBoardResponseDto;
import com.usopen.backend.dto.response.board.PostBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {
  ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
  ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}
