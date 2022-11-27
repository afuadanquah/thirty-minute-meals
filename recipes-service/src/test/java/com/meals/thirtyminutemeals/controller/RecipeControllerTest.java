package com.meals.thirtyminutemeals.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import com.meals.thirtyminutemeals.model.Ingredients;
import com.meals.thirtyminutemeals.model.Recipe;
import com.meals.thirtyminutemeals.service.RecipeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

  @Autowired
  private MockMvc mockMvc;


  @MockBean
  private RecipeService recipeService;

  private List<Recipe> mockRecipe;

  @BeforeEach
  public void setUp(){
    List<Ingredients> oneIngredient = new ArrayList<>();
    oneIngredient.add(new Ingredients("1st", 4));

    mockRecipe = new ArrayList<>();
    mockRecipe.add(new Recipe("1", "a", oneIngredient, 4, 4, "notes"));
    mockRecipe.add(new Recipe("2", "a", oneIngredient, 4, 4, "notes"));
  }


  @DisplayName("Returns all recipes when called")
  @Test
  public void whenGetAllRecipesIsCalled() throws Exception {


    //Given
    given(recipeService.getAllRecipes()).willReturn(mockRecipe);

    //When
    MockHttpServletResponse response = mockMvc.perform(get("/thirty-min-meals/recipes").accept(
            MediaType.APPLICATION_JSON)).andReturn().getResponse();


    //then
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    String jsonString = new Gson().toJson(mockRecipe);

    assertThat(response.getContentAsString()).isEqualTo(jsonString);

  }

  @Test
  @DisplayName("Returns recipes that are called by ID")
  public void whenGetRecipeByID() throws Exception {
    //Given
    given(recipeService.getRecipeByID("2")).willReturn(mockRecipe.get(1));

    String jsonString = new Gson().toJson(mockRecipe.get(1));

    //When
    mockMvc.perform(get("/thirty-min-meals/recipe/" + mockRecipe.get(1).getId()))
        .andExpect(status().isOk()) //Then
        .andExpect(content().json(jsonString)) //Then
        .andExpect(content().contentType("application/json")); //Then
  }
  }

