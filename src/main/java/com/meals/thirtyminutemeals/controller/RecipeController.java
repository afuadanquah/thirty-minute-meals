package com.meals.thirtyminutemeals.controller;

import com.meals.thirtyminutemeals.model.Recipe;
import com.meals.thirtyminutemeals.service.RecipeService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recipe")
public class RecipeController {

  @Autowired
  private RecipeService recipeService;

  @PostConstruct
  public void saveRecipes(){
    List<Recipe> recipes = new ArrayList<>();
    recipes.add(new Recipe("1", "Banana", "Banana", 4, 15, "peel it"));
    recipes.add(new Recipe("2", "Carrot", "Carrot", 6, 20, "cut it"));
    recipes.add(new Recipe("3", "Lemon", "Lem", 2, 2, "zestit"));

    recipeService.initializeRecipes(recipes);
  }

  @GetMapping("/all")
  public List <Recipe> getAllRecipes(){
    List<Recipe> recipes = recipeService.getAllTheRecipes();
    return recipes;
  }



}
