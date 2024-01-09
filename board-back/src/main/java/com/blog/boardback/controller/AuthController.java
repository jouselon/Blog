package com.blog.boardback.controller;

import com.blog.boardback.dto.request.auth.SignInRequestDto;
import com.blog.boardback.dto.request.auth.SignUpRequestDto;
import com.blog.boardback.dto.response.auth.SignInResponseDto;
import com.blog.boardback.dto.response.auth.SignUpResponseDto;
import com.blog.boardback.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/sign-up")
  public ResponseEntity<? super SignUpResponseDto> signUp(
      @RequestBody @Valid SignUpRequestDto requestBody
      ) {
      ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
      return response;
  }

  @PostMapping("/sign-in")
  public ResponseEntity<? super SignInResponseDto> signIn(
      @RequestBody @Valid SignInRequestDto requestDto
      ){
    ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestDto);
    return response;
  }
}
