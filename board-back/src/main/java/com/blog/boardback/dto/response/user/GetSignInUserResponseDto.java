package com.blog.boardback.dto.response.user;

import com.blog.boardback.common.ResponseCode;
import com.blog.boardback.common.ResponseMessage;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.entity.UserEntity;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetSignInUserResponseDto extends ResponseDto {

  private String email;
  private String nickname;
  private String profileImage;

  private GetSignInUserResponseDto(UserEntity userEntity) {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.email = userEntity.getEmail();
    this.nickname = userEntity.getNickname();
    this.profileImage = userEntity.getProfileImage();
  }
  public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity userEntity){
    GetSignInUserResponseDto result = new GetSignInUserResponseDto(userEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  public static ResponseEntity<ResponseDto> notExistUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
  }
}
