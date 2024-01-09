package com.blog.boardback.service;

import com.blog.boardback.dto.request.auth.SignInRequestDto;
import com.blog.boardback.dto.request.auth.SignUpRequestDto;
import com.blog.boardback.dto.response.auth.SignInResponseDto;
import com.blog.boardback.dto.response.auth.SignUpResponseDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
  ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
  ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
