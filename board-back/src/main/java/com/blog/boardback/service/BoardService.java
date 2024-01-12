package com.blog.boardback.service;

import com.blog.boardback.dto.request.board.PostBoardRequestDto;
import com.blog.boardback.dto.response.board.GetBoardResponseDto;
import com.blog.boardback.dto.response.board.PostBoardResponseDto;
import com.blog.boardback.dto.response.board.PutFavoriteResponseDto;
import org.springframework.http.ResponseEntity;

public interface BoardService {
  ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
  ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
  ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

}
