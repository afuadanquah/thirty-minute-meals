package com.meals.thirtyminutemeals.ft.utils;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestHttpClient {
  RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

  @Value("${service.base.url}")
  String serviceBaseUri;

  public void resetSpecification() {
    requestSpecBuilder = new RequestSpecBuilder();
    requestSpecBuilder.setBaseUri(serviceBaseUri);
    log.info("Service base uri : " + serviceBaseUri);
  }

  public Response sendGetRequest(String endpoint) {
    RequestSpecification requestSpecification = requestSpecBuilder.build();
    return given(requestSpecification).get(endpoint);
  }

//  TODO need to investigate how to add POST into a database and retrieve the correct total of items
//  public Response sendPostRequest(String endpoint, List<Recipe> body) {
//    RequestSpecification requestSpecification = requestSpecBuilder.setBody(body).build();
//    return given(requestSpecification).post(endpoint);
//  }
}
