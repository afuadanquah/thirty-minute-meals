package com.meals.thirtyminutemeals.controller;

import com.meals.thirtyminutemeals.model.Ingredients;
import com.meals.thirtyminutemeals.model.Recipe;

import com.meals.thirtyminutemeals.service.RecipeService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thirty-min-meals")
public class RecipeController {

  @Autowired
  private RecipeService recipeService;

  @PostConstruct
  public void saveRecipes(){
    List<Recipe> recipes = new ArrayList<>();
    List<Ingredients> bananaIngredients = new ArrayList<>();
    bananaIngredients.add(new Ingredients("Banana", 5));

    List<Ingredients> carrotIngredients = new ArrayList<>();
    carrotIngredients.add(new Ingredients("Carrot", 5));

    List<Ingredients> lemonIngredients = new ArrayList<>();
    lemonIngredients.add(new Ingredients("Lemon", 5));

    recipes.add(new Recipe("1", "Banana Bread", bananaIngredients, 4, 5, "Bake it!"));
    recipes.add(new Recipe("2", "Carrot Cake", carrotIngredients, 6, 20, "Bake it!"));
    recipes.add(new Recipe("3", "Lemon Cake", lemonIngredients, 2, 2, "Bake it!"));

    recipeService.initializeRecipes(recipes);
  }


  @GetMapping("/recipes")
  public ResponseEntity<List<Recipe>> getAllRecipes(){
    List<Recipe> recipes = recipeService.getAllRecipes();
    return new ResponseEntity<>(recipes, HttpStatus.OK);
  }

  @GetMapping("/recipe/{id}")
  public ResponseEntity<Recipe> getRecipeByID(@PathVariable String id){
    Recipe getRecipeByID = recipeService.getRecipeByID(id);
    return new ResponseEntity<>(getRecipeByID, HttpStatus.OK);
  }

  @PostMapping(path = "/add-recipe")
  public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe){
    Recipe addRecipe = recipeService.addRecipe(recipe);
    return new ResponseEntity<>(addRecipe, HttpStatus.CREATED);
  }

  @PostMapping(path = "/add-recipes")
  public ResponseEntity<List<Recipe>> saveRecipe(@RequestBody List<Recipe> recipe){
    List<Recipe> addRecipe = recipeService.addRecipes(recipe);
    return new ResponseEntity<>(addRecipe, HttpStatus.CREATED);
  }

  @DeleteMapping("/delete-recipe/{id}")
  public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") String id){
    recipeService.deleteRecipe(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/delete-recipes")
  public ResponseEntity<HttpStatus> deleteRecipes(List<Recipe> recipes){
    recipeService.deleteAllRecipes(recipes);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/update-recipe/{id}")
  public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") String id, @RequestBody Recipe recipe){
    Recipe updateRecipe = recipeService.updateRecipe(recipe, id);
    return new ResponseEntity(updateRecipe, HttpStatus.OK);
  }


}
