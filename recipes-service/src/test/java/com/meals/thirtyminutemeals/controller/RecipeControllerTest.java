package com.meals.thirtyminutemeals.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.meals.thirtyminutemeals.model.Ingredients;
import com.meals.thirtyminutemeals.model.Recipe;
import com.meals.thirtyminutemeals.service.RecipeService;
import java.nio.charset.StandardCharsets;
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

  @Autowired
  private ObjectMapper objectMapper;


  @MockBean
  private RecipeService recipeService;

  private List<Recipe> mockRecipe;

  @BeforeEach
  public void setUp(){
    mockRecipe = new ArrayList<>();

    List<Ingredients> testIngredientsOne = new ArrayList<>();
    testIngredientsOne.add(new Ingredients("Fresh or Frozen Salmon Fillet, skinned if desired", "11 pound"));
    testIngredientsOne.add(new Ingredients("Salt", "1/8 tsp"));
    testIngredientsOne.add(new Ingredients("Salt", "1/4 tsp"));
    testIngredientsOne.add(new Ingredients("Black Pepper", "1/8 tsp"));
    testIngredientsOne.add(new Ingredients("Black Pepper", "1/4 tsp"));
    testIngredientsOne.add(new Ingredients("Nonstick Cooking Spray", "N/A"));
    testIngredientsOne.add(new Ingredients("Thinly Sliced Shallots", "1/2 cup"));
    testIngredientsOne.add(new Ingredients("Chopped Fresh Oregano", "2 tbsp"));
    testIngredientsOne.add(new Ingredients("Olive Oil", "2 tbsp"));

    mockRecipe.add(new Recipe("1", "Salmon with Roasted Tomatoes and Shallots", testIngredientsOne, 4, "30 minutes",
        "1. Thaw salmon, if frozen. Preheat oven to 400°F. Sprinkle salmon with the 1/8 tsp. each salt and pepper. " +
            "2. Lightly coat a 3-qt. rectangular baking dish with cooking spray. In the baking dish combine the remaining ingredients. Toss to coat. " +
            "3. Roast tomato mixture, uncovered, 15 minutes. Place salmon, skin side down, on top of tomato mixture. Roast, uncovered, 15 to 18 minutes or until salmon flakes easily. " +
            "4. Using two large pancake turners, transfer the salmon to a platter. Top with tomato mixture."));


    List<Ingredients> testIngredientsTwo = new ArrayList<>();
    testIngredientsTwo.add(new Ingredients("Sweet Potatoes, peeled and cut into chunks", "600g"));
    testIngredientsTwo.add(new Ingredients("Garlic Clove, peeled", "1"));
    testIngredientsTwo.add(new Ingredients("Parmesan, finely grated, plus more to serve", "25g"));
    testIngredientsTwo.add(new Ingredients("Double Cream", "150ml"));
    testIngredientsTwo.add(new Ingredients("Spaghetti", "350g"));
    testIngredientsTwo.add(new Ingredients("Frozen Spinach", "300g"));


    mockRecipe.add(new Recipe("2", "Sweet Potato Spaghetti", testIngredientsTwo, 4, "20 minutes",
        "1. Boil the sweet potatoes and peeled garlic clove in a pan over a medium-high heat with the lid on for 10-15 mins until the potato is really tender and falls off a fork easily when pierced. Drain well. " +
            "2. Finely chop the blanched garlic clove, then tip back into the pan with the drained sweet potatoes. Add the Parmesan and double cream, then blend to a smooth, thick sauce using a stick blender. " +
            "3. Meanwhile, cook the pasta according to pack instructions, adding the spinach to the pan for the last 3 mins. Drain well, reserving 100ml of the pasta water. Tip the spaghetti and spinach into the sweet potato sauce and add the reserved water. Toss everything together until the spaghetti is well coated. Season, then pile into bowls with more Parmesan grated over the top."));
  }

  //GET
  @Test
  @DisplayName("Returns all recipes when called")
  public void whenGetAllRecipesIsCalled() throws Exception {


    //Given
    given(recipeService.getAllRecipes()).willReturn(mockRecipe);

    //When
    MockHttpServletResponse response = mockMvc.perform(get("/thirty-min-meals/recipes").accept(
            MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();


    //then
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    String jsonString = new Gson().toJson(mockRecipe);

    assertThat(response.getContentAsString(StandardCharsets.UTF_8)).isEqualTo(jsonString);

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

  //DELETE
  @Test
  @DisplayName("Confirm recipe is deleted by ID")
  public void whenDeleteRecipeByID() throws Exception {

    doNothing().when(recipeService).deleteRecipe(mockRecipe.get(1).toString());

    mockMvc.perform(delete("/thirty-min-meals/delete-recipe/" + mockRecipe.get(1).getId()))
        .andExpect(status().isNoContent());

  }

  //POST
  @Test
  @DisplayName("Create a single recipe")
  public void whenCreateASingleRecipe() throws Exception {

    given(recipeService.addRecipe(mockRecipe.get(0))).willReturn(mockRecipe.get(0));

    mockMvc.perform(post("/thirty-min-meals/add-recipe")
            .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mockRecipe.get(0))))
        .andExpect(status().isCreated())
        .andDo(print());

  }

  @Test
  @DisplayName("Create a multiple recipes")
  public void whenCreateMultipleRecipes() throws Exception {

    given(recipeService.addRecipes(mockRecipe)).willReturn(mockRecipe);

    mockMvc.perform(post("/thirty-min-meals/add-recipes")
            .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mockRecipe)))
        .andExpect(status().isCreated())
        .andDo(print());

  }


  //PUT
  @Test
  @DisplayName("Update a recipe by ID")
  public void whenUpdateARecipeByID() throws Exception {

    List<Ingredients> testIngredientsTwo = new ArrayList<>();
    testIngredientsTwo.add(new Ingredients("Sweet Potatoes, peeled and cut into chunks", "1.2kg"));
    testIngredientsTwo.add(new Ingredients("Garlic Clove, peeled", "2"));
    testIngredientsTwo.add(new Ingredients("Parmesan, finely grated, plus more to serve", "50g"));
    testIngredientsTwo.add(new Ingredients("Double Cream", "300ml"));
    testIngredientsTwo.add(new Ingredients("Spaghetti", "700g"));
    testIngredientsTwo.add(new Ingredients("Frozen Spinach", "600g"));

    Recipe updatedRecipe = new Recipe("2", "Sweet Potato Spaghetti", testIngredientsTwo, 8, "20 minutes",
        "1. Boil the sweet potatoes and peeled garlic clove in a pan over a medium-high heat with the lid on for 10-15 mins until the potato is really tender and falls off a fork easily when pierced. Drain well. " +
            "2. Finely chop the blanched garlic clove, then tip back into the pan with the drained sweet potatoes. Add the Parmesan and double cream, then blend to a smooth, thick sauce using a stick blender. " +
            "3. Meanwhile, cook the pasta according to pack instructions, adding the spinach to the pan for the last 3 mins. Drain well, reserving 100ml of the pasta water. Tip the spaghetti and spinach into the sweet potato sauce and add the reserved water. Toss everything together until the spaghetti is well coated. Season, then pile into bowls with more Parmesan grated over the top.");

    given(recipeService.updateRecipe(updatedRecipe, "2")).willReturn(updatedRecipe);

    mockMvc.perform(put("/thirty-min-meals/update-recipe/" + updatedRecipe.getId())
        .content(objectMapper.writeValueAsString(updatedRecipe))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  }

