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

  public Recipe addOneRecipe(String name, String ingredient_name, int ingredient_quantity, int serves, int duration, String instructions){

    List<Ingredients> ingredient = new ArrayList<>();
    ingredient.add(new Ingredients(ingredient_name, ingredient_quantity));


    Recipe recipe = new Recipe(UUID.randomUUID().toString(), name, ingredient, serves, duration, instructions);

    return recipeRepository.save(recipe);
  }


}
