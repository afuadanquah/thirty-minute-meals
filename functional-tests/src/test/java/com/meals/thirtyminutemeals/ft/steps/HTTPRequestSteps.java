package com.meals.thirtyminutemeals.ft.steps;


import com.meals.thirtyminutemeals.ft.model.TestHTTPRequest;
import com.meals.thirtyminutemeals.ft.utils.TestHttpClient;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

@Slf4j
public class HTTPRequestSteps {

  private final TestHTTPRequest httpRequest;
  private final TestHttpClient client;

  public HTTPRequestSteps(TestHTTPRequest httpRequest,
                          TestHttpClient client) {
    this.httpRequest = httpRequest;
    this.client = client;
  }


  @Before
  public void setup() {
    client.resetSpecification();

  }

  @When("Client makes a request to {string} endpoint")
  public void clientMakesARequestTo(String endpoint) {
    log.info("Endpoint is {}", endpoint);
    httpRequest.setResponse(client.sendGetRequest(endpoint));
  }

  @Then("Client receives a body of {string}")
  public void clientReceivesABodyOf(String body) {
    Assertions.assertEquals(body, httpRequest.getResponseBody());
    log.info(String.valueOf(httpRequest.getResponse().getBody().jsonPath()));
  }

//  @Then("Client adds one recipe")
//  public void addOneRecipe(){
//    List<Ingredients> oneIngredient = new ArrayList<>();
//    oneIngredient.add(new Ingredients("1st", 4));
//
//    List<Recipe> mockRecipe = new ArrayList<>();
//    mockRecipe.add(new Recipe("8", "a", oneIngredient, 4, 4, "notes"));
//    String jsonString = new Gson().toJson(mockRecipe);
//
//    httpRequest.setResponse(client.sendPostRequest("/thirty-min-meals/add-recipe", mockRecipe));
//  }



  @Then("Client checks that there are {int} recipes are available")
  public void clientChecksThatThereAreRecipesAreAvailable(int num) {


    JsonPath jsonPath1 = httpRequest.getResponse().body().jsonPath();

    List<Map<String, String>> object = jsonPath1.getList("id");

    Assertions.assertEquals(num, object.size());
  }

  @And("Client receives a status code of {int}")
  public void clientReceivesAStatusCodeOf(int code) {
    Assertions.assertEquals(code, httpRequest.getStatusCode());
  }
}
