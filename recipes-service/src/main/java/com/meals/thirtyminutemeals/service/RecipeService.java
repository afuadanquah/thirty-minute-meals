package com.meals.thirtyminutemeals.service;

import com.meals.thirtyminutemeals.model.Ingredients;
import com.meals.thirtyminutemeals.model.Recipe;
import com.meals.thirtyminutemeals.repository.RecipeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RecipeService {

  @Autowired
  RecipeRepository recipeRepository;

  public void initializeRecipes(List<Recipe> recipes){
    List<Recipe> saveRecipes = recipeRepository.saveAll(recipes);
  }

  public List<Recipe> getAllTheRecipes(){
    List<Recipe> recipes = recipeRepository.findAll();

    return recipes;
  }

  public Recipe addRecipe(Recipe recipe){
     return recipeRepository.save(recipe);

  }


  public List<Recipe> addRecipes(List<Recipe> recipe) {
    return recipeRepository.saveAll(recipe);
  }
}
