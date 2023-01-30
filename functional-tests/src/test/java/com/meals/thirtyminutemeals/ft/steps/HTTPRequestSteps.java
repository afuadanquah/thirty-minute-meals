package com.meals.thirtyminutemeals.ft.steps;


import com.google.gson.Gson;
import com.meals.thirtyminutemeals.ft.model.TestHTTPRequest;
import com.meals.thirtyminutemeals.ft.utils.TestHttpClient;
import com.meals.thirtyminutemeals.model.Ingredients;
import com.meals.thirtyminutemeals.model.Recipe;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

@Slf4j
public class HTTPRequestSteps {

  private final TestHTTPRequest httpRequest;
  private final TestHttpClient client;

  private static final Map<String, String> endpoints = new HashMap<>(){
    {
      put("all-recipes-api", "/thirty-min-meals/recipes");
      put("add-recipe", "/thirty-min-meals/add-recipe");
      put("private-status", "/private/status");
      put("delete-recipe", "/thirty-min-meals/delete-recipe/");
      put("update-recipe", "/thirty-min-meals/update-recipe/");
    }
  };



  public HTTPRequestSteps(TestHTTPRequest httpRequest,
                          TestHttpClient client) {
    this.httpRequest = httpRequest;
    this.client = client;
  }



  @Before
  public void setup() {
    client.resetSpecification();

  }

  @When("Client makes a {string} request to {string} endpoint")
  public void clientMakesARequestTo(String request, String endpoint) {
    if(request.equals("GET")){
      log.info("Endpoint is {}", endpoints.get(endpoint));
      httpRequest.setResponse(client.sendGetRequest(endpoints.get(endpoint)));
    } else if (request.equals("POST")){
      log.info("Endpoint is {}", endpoints.get(endpoint));

      List<Ingredients> oneIngredient = new ArrayList<>();

          oneIngredient.add(new Ingredients("1st Ingredient", "1"));
          oneIngredient.add(new Ingredients("2nd Ingredient", "2"));
          oneIngredient.add(new Ingredients("3rd Ingredient", "3"));
          oneIngredient.add(new Ingredients("4th Ingredient", "4"));

      List<Recipe> mockRecipe = new ArrayList<>();
          mockRecipe.add(new Recipe("8", "1st recipe", oneIngredient, 4, "10 mins", "notes"));


          String jsonString = new Gson().toJson(mockRecipe.get(0));

      httpRequest.setResponse(client.sendPostRequest(endpoints.get(endpoint), jsonString));
    }


  }

  @Then("Client receives a body of {string}")
  public void clientReceivesABodyOf(String body) {
    Assertions.assertEquals(body, httpRequest.getResponseBody());
    log.info(String.valueOf(httpRequest.getResponse().getBody().jsonPath()));
  }



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

  @Then("Client checks that the recipe is available")
  public void clientChecksThatTheRecipeIsAvailable() {
    List<Ingredients> oneIngredient = new ArrayList<>();

    oneIngredient.add(new Ingredients("1st Ingredient", "1"));
    oneIngredient.add(new Ingredients("2nd Ingredient", "2"));
    oneIngredient.add(new Ingredients("3rd Ingredient", "3"));
    oneIngredient.add(new Ingredients("4th Ingredient", "4"));

    List<Recipe> mockRecipe = new ArrayList<>();
    mockRecipe.add(new Recipe("8", "1st recipe", oneIngredient, 4, "10 mins", "notes"));


    String jsonString = new Gson().toJson(mockRecipe.get(0));
    Assertions.assertEquals(jsonString, httpRequest.getResponseBody());
  }

  @When("Client makes a {string} request to {string} endpoint with the {string}")
  public void clientMakesARequestToEndpointWithTheId(String request, String endpoint, String id) {
    if (request.equals("DELETE")) {
      log.info("Endpoint is {}", endpoints.get(endpoint));
      String deleteEndpoint = endpoints.get(endpoint) + id;
      httpRequest.setResponse(client.sendDeleteRequest(deleteEndpoint));
    } else if (request.equals("PUT")) {
      log.info("Endpoint is {}", endpoints.get(endpoint) + id);
      String updateEndpoint = endpoints.get(endpoint) + id;
      List<Ingredients> oneIngredient1 = new ArrayList<>();

      oneIngredient1.add(new Ingredients("First Ingredient", "1"));
      oneIngredient1.add(new Ingredients("Second Ingredient", "2"));
      oneIngredient1.add(new Ingredients("Third Ingredient", "3"));
      oneIngredient1.add(new Ingredients("Fourth Ingredient", "4"));

      List<Recipe> mockRecipe1 = new ArrayList<>();
      mockRecipe1.add(new Recipe("8", "Updated Recipe", oneIngredient1, 4, "10 mins", "notes"));


      String json = new Gson().toJson(mockRecipe1.get(0));


      httpRequest.setResponse(client.sendPutRequest(json, updateEndpoint));


    }
  }


}
