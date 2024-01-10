package com.blog.boardback.service;

import com.blog.boardback.dto.request.board.PostBoardRequestDto;
import com.blog.boardback.dto.response.board.PostBoardResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {
  ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
}
