package com.blog.boardback.common;

public interface ResponseMessage {
  //HTTP  Status 200
  String SUCCESS = "Success";

  //HTTP Status 400
  String VALIDATION_FAILED = "Validation Failed";
  String DUPLICATE_EMAIL = "Duplicate Email";
  String DUPLICATE_NICKNAME = "DUPLICATE NICKNAME";
  String DUPLICATE_TEL_NUMBER = "DUPLICATE TEL NUMBER";
  String NOT_EXISTED_USER = "NOT EXISTED USER";
  String NOT_EXISTED_BOARD = "NOT EXISTED BOARD";

  //HTTP Status 401
  String SIGN_IN_FAILED = "SIGN IN FAILED";
  String AUTHORIZATION_FAILED = "AUTHORIZATION FAILED";

  //HTTP Status 403
  String NO_PERMISSION = "NO PERMISSION";

  //HTTP Status 500
  String DATABASE_ERROR = "DATABASE ERROR";

}
