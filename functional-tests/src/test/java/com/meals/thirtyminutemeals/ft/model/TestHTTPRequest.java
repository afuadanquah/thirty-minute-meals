package com.meals.thirtyminutemeals.ft.model;

import io.restassured.response.Response;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class TestHTTPRequest {

  private Response response;

  public int getStatusCode() {
    return response.getStatusCode();
  }

  public String getResponseBody() {
    try {
      return response.getBody().asString();
    } catch (Exception e) {
      log.error(e.getMessage());
      return "";
    }
  }


}
