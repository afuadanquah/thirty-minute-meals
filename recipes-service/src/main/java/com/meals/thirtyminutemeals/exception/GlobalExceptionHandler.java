package com.meals.thirtyminutemeals.exception;

import com.meals.thirtyminutemeals.enums.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorModel> standardException(Exception ex){
    log.error("This is the following error: " + ex.getClass() + " and here is the message: " + ex.getMessage());
    ErrorModel errorResponse = new ErrorModel(ErrorEnum.GENERAL_ERROR);
    return new ResponseEntity<ErrorModel>(errorResponse, HttpStatus.NOT_FOUND);
  }





}
