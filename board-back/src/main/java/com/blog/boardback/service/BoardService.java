package com.blog.boardback.service;

import com.blog.boardback.dto.request.board.PostBoardRequestDto;
import com.blog.boardback.dto.request.board.PostCommentRequestDto;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.dto.response.board.*;
import org.springframework.http.ResponseEntity;

public interface BoardService {
  ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
  ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
   ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
  ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email);
  ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
  ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
  ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);

}
