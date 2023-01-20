package com.meals.thirtyminutemeals.exception;

import com.meals.thirtyminutemeals.enums.ErrorEnum;

public class ErrorModel {

  private String message;
  private String errorCode;

  public ErrorModel(ErrorEnum errorEnum) {
    this.message = errorEnum.getMessage();
    this.errorCode = errorEnum.getCode();
  }

  public String getMessage() {
    return message;
  }

  public String getErrorCode() {
    return errorCode;
  }

}
