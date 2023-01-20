package com.meals.thirtyminutemeals.enums;

public enum ErrorEnum {

  GENERAL_ERROR("000", "Unexpected General Error");

  ErrorEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  private String code;
  private String message;
}
