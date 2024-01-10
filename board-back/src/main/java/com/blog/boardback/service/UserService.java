package com.blog.boardback.service;

import com.blog.boardback.dto.response.user.GetSignInUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
  ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);

}
