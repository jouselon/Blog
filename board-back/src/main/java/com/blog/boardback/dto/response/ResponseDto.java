package com.blog.boardback.dto.response;

import com.blog.boardback.common.ResponseCode;
import com.blog.boardback.common.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class ResponseDto {

  // 응답 코드
  private String code;

  // 응답 메시지
  private String message;

  // 데이터베이스 오류 응답을 생성하는 정적 팩토리 메서드
  public static ResponseEntity<ResponseDto> databaseError() {
    // ResponseDto 객체 생성
    ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);

    // ResponseEntity를 사용하여 HTTP 상태 코드 및 응답 본문을 설정하여 반환
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
  }
}
