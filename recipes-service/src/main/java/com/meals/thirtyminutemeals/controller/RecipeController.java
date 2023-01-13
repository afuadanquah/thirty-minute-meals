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

    List<Ingredients> mackerelIngredients = new ArrayList<>();
    mackerelIngredients.add(new Ingredients("New Potatoes, halved", "250g"));
    mackerelIngredients.add(new Ingredients("Oil", "2 tbsp"));
    mackerelIngredients.add(new Ingredients("Large Leeks, sliced", "2"));
    mackerelIngredients.add(new Ingredients("Eggs", "4"));
    mackerelIngredients.add(new Ingredients("Horseradish, creamed", "2 tbsp"));

    recipes.add(new Recipe("1", "Smoked mackerel and leek hash with horseradish", mackerelIngredients, 2, "30 minutes",
        "1. Put the potatoes in a microwaveable bowl with a splash of water, cover, then cook on high for 5 mins until tender (or steam or simmer them). " +
            "2. Meanwhile, heat the oil in a frying pan over a medium heat, add the leeks with a pinch of salt and cook for 10 mins, stirring so they don’t stick, until softened. Tip in the potatoes, turn up the heat and fry for a couple of mins to crisp them up a bit. Flake through the mackerel. " +
            "3. Make four indents in the leek mixture in the pan, crack an egg into each, season, then cover the pan and cook for 6-8 mins until the whites have set and the yolks are runny. Serve the horseradish on the side, with the pan in the middle of the table. "));


    List<Ingredients> blackTahiniIngredients = new ArrayList<>();
    blackTahiniIngredients.add(new Ingredients("Fine Rice Noodles", "150g"));
    blackTahiniIngredients.add(new Ingredients("Limes", "2"));
    blackTahiniIngredients.add(new Ingredients("Punnet of Cress", "1"));
    blackTahiniIngredients.add(new Ingredients("Black Sesame Seeds", "50g"));
    blackTahiniIngredients.add(new Ingredients("Teriyaki Sauce", "2 tbsp"));

    recipes.add(new Recipe("2", "Black tahini noodles", blackTahiniIngredients, 2, "13 minutes",
        "1. Cook the noodles in boiling salted water according to the packet instructions, then drain, reserving a mugful of cooking water. Meanwhile, finely grate the zest of 1 lime, snip the cress and put both aside. " +
                    "2. Toast the sesame seeds in a dry non-stick frying pan on a high heat for 1 minute, tossing regularly. Reserving one quarter of the seeds, pound the rest in a pestle and mortar until fairly fine, then muddle in the teriyaki and the juice of 1 lime. Taste, season to perfection with sea salt and black pepper, and you’ve got a black tahini! " +
    "3. Toss the noodles and black tahini together, loosening with a splash of reserved noodle water. Serve sprinkled with the lime zest, cress and reserved seeds, with lime wedges on the side, for squeezing over."));


    List<Ingredients> lambKoftaIngredients = new ArrayList<>();
    lambKoftaIngredients.add(new Ingredients("Minced Lamb", "250g"));
    lambKoftaIngredients.add(new Ingredients("Rose Harissa", "2 tsp"));
    lambKoftaIngredients.add(new Ingredients("Red Cabbage", "250g"));
    lambKoftaIngredients.add(new Ingredients("Seeded Wholemeal Tortillas", "2"));
    lambKoftaIngredients.add(new Ingredients("Cottage Cheese", "2"));

    recipes.add(new Recipe("3", "Lamb Kofta Flatbreads", lambKoftaIngredients, 2, "15 minutes",
        "1. Put a griddle pan on a high heat. " +
            "2. Scrunch the minced lamb and harissa in your clean hands until well mixed. " +
            "3. Divide into 6 pieces, then shape into koftas with your fingertips, leaving dents in the surface to increase the gnarly bits as they cook. " +
            "4. Griddle for 4 to 5 minutes on each side, or until sizzling and golden. " +
            "5. Meanwhile, shred the red cabbage as finely as you can. Sprinkle with a pinch of sea salt and black pepper, drizzle with 1 tablespoon of red wine vinegar, then scrunch together to quickly pickle it. " +
            "6. Warm your tortillas or flatbreads, sprinkle over the cabbage, spoon over the cottage cheese, add the koftas, drizzle with a little extra harissa, and tuck in."));

    recipeService.initializeRecipes(recipes);
  }


  @GetMapping("/recipes")
  public ResponseEntity<List<Recipe>> getAllRecipes(){
    List<Recipe> recipes = recipeService.getAllRecipes();
    return new ResponseEntity<>(recipes, HttpStatus.OK);
  }

  @GetMapping("/recipe/{id}")
  public ResponseEntity<Recipe> getRecipeByID(@PathVariable String id) throws Exception {
    Recipe getRecipeByID = recipeService.getRecipeByID(id);
    return new ResponseEntity<>(getRecipeByID, HttpStatus.OK);
  }

  @PostMapping(path = "/add-recipe")
  public ResponseEntity<Recipe> saveSingle(@RequestBody Recipe recipe){
    Recipe addRecipe = recipeService.addRecipe(recipe);
    return new ResponseEntity<>(addRecipe, HttpStatus.CREATED);
  }

  @PostMapping(path = "/add-recipes")
  public ResponseEntity<List<Recipe>> saveMultipleRecipes(@RequestBody List<Recipe> recipe){
    List<Recipe> addRecipe = recipeService.addRecipes(recipe);
    return new ResponseEntity<>(addRecipe, HttpStatus.CREATED);
  }

  @DeleteMapping("/delete-recipe/{id}")
  public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") String id){
    recipeService.deleteRecipe(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/delete-recipes")
  public ResponseEntity<HttpStatus> deleteRecipes(@RequestBody List<Recipe> recipes){
    recipeService.deleteAllRecipes(recipes);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/update-recipe/{id}")
  public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") String id, @RequestBody Recipe recipe)
      throws Exception {
    Recipe updateRecipe = recipeService.updateRecipe(recipe, id);
    return new ResponseEntity<>(updateRecipe, HttpStatus.OK);
  }


}
