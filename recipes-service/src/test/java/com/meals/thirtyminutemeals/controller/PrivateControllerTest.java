package com.meals.thirtyminutemeals.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PrivateControllerTest {

  @InjectMocks
  private PrivateController privateController;

  @DisplayName("Returns the Body and Status Code of Private Controller")
  @Test
  public void whenStatusIsCalled_ReturnsBodyOKAndStatusCode(){
    ResponseEntity<String> response = privateController.returnStatus();

    assertAll(
        () -> assertEquals("OK", response.getBody()),
        () -> assertEquals(HttpStatus.OK, response.getStatusCode())
    );

  }

}
