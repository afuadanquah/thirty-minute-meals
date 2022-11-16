package com.meals.thirtyminutemeals.service;

import com.meals.thirtyminutemeals.model.Recipe;
import com.meals.thirtyminutemeals.repository.RecipeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
