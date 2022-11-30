package com.meals.thirtyminutemeals.service;

import com.meals.thirtyminutemeals.model.Recipe;
import com.meals.thirtyminutemeals.repository.RecipeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

  @Autowired
  RecipeRepository recipeRepository;

  public void initializeRecipes(List<Recipe> recipes){
    List<Recipe> saveRecipes = recipeRepository.saveAll(recipes);
  }

  //GET logic(s)
  public List<Recipe> getAllRecipes(){
    List<Recipe> recipes = recipeRepository.findAll();

    return recipes;
  }

  public Recipe getRecipeByID(String id){
    Optional<Recipe> recipeByID = recipeRepository.findById(id);

    Recipe recipe = recipeByID.get();

    return recipe;
  }


  //POST logic(s)
  public Recipe addRecipe(Recipe recipe){
     return recipeRepository.save(recipe);

  }

  public List<Recipe> addRecipes(List<Recipe> recipe) {
    return recipeRepository.saveAll(recipe);
  }


  //DELETE logic(s)
  public void deleteRecipe(String id){
     recipeRepository.deleteById(id);
  }

  public void deleteAllRecipes(List<Recipe> recipes){
    recipeRepository.deleteAll(recipes);
  }


  //PUT logic(s)
  public Recipe updateRecipe(Recipe recipe, String id){

    Optional<Recipe> recipeData = recipeRepository.findById(id);

    Recipe updatedRecipe = recipeData.get();

      updatedRecipe.setDuration(recipe.getDuration());
      updatedRecipe.setIngredients(recipe.getIngredients());
      updatedRecipe.setInstructions(recipe.getInstructions());
      updatedRecipe.setName(recipe.getName());
      updatedRecipe.setServing(recipe.getServing());

      return recipeRepository.save(updatedRecipe);



  }
}
