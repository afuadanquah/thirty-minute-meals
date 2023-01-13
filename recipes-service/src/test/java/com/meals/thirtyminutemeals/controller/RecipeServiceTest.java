package com.meals.thirtyminutemeals.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.meals.thirtyminutemeals.model.Ingredients;
import com.meals.thirtyminutemeals.model.Recipe;
import com.meals.thirtyminutemeals.repository.RecipeRepository;
import com.meals.thirtyminutemeals.service.RecipeService;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

  //Recipe Service = new RecipeService (Recipe Repository)

  @InjectMocks
  private RecipeService recipeService;

  @Mock
  private RecipeRepository recipeRepository;

  @Test
  public void returnListOfRecipes_whenGivenRecipes(){
    List<Recipe> recipeList = new ArrayList<>();

    List<Ingredients> mackerelIngredients = new ArrayList<>();
    mackerelIngredients.add(new Ingredients("New Potatoes, halved", "250g"));
    mackerelIngredients.add(new Ingredients("Oil", "2 tbsp"));
    mackerelIngredients.add(new Ingredients("Large Leeks, sliced", "2"));
    mackerelIngredients.add(new Ingredients("Eggs", "4"));
    mackerelIngredients.add(new Ingredients("Horseradish, creamed", "2 tbsp"));

    recipeList.add(new Recipe("1", "Smoked mackerel and leek hash with horseradish", mackerelIngredients, 2, "30 minutes",
        "1. Put the potatoes in a microwaveable bowl with a splash of water, cover, then cook on high for 5 mins until tender (or steam or simmer them). " +
            "2. Meanwhile, heat the oil in a frying pan over a medium heat, add the leeks with a pinch of salt and cook for 10 mins, stirring so they don’t stick, until softened. Tip in the potatoes, turn up the heat and fry for a couple of mins to crisp them up a bit. Flake through the mackerel. " +
            "3. Make four indents in the leek mixture in the pan, crack an egg into each, season, then cover the pan and cook for 6-8 mins until the whites have set and the yolks are runny. Serve the horseradish on the side, with the pan in the middle of the table. "));


    List<Ingredients> blackTahiniIngredients = new ArrayList<>();
    blackTahiniIngredients.add(new Ingredients("Fine Rice Noodles", "150g"));
    blackTahiniIngredients.add(new Ingredients("Limes", "2"));
    blackTahiniIngredients.add(new Ingredients("Punnet of Cress", "1"));
    blackTahiniIngredients.add(new Ingredients("Black Sesame Seeds", "50g"));
    blackTahiniIngredients.add(new Ingredients("Teriyaki Sauce", "2 tbsp"));

    recipeList.add(new Recipe("2", "Black tahini noodles", blackTahiniIngredients, 2, "13 minutes",
        "1. Cook the noodles in boiling salted water according to the packet instructions, then drain, reserving a mugful of cooking water. Meanwhile, finely grate the zest of 1 lime, snip the cress and put both aside. " +
            "2. Toast the sesame seeds in a dry non-stick frying pan on a high heat for 1 minute, tossing regularly. Reserving one quarter of the seeds, pound the rest in a pestle and mortar until fairly fine, then muddle in the teriyaki and the juice of 1 lime. Taste, season to perfection with sea salt and black pepper, and you’ve got a black tahini! " +
            "3. Toss the noodles and black tahini together, loosening with a splash of reserved noodle water. Serve sprinkled with the lime zest, cress and reserved seeds, with lime wedges on the side, for squeezing over."));

  when(recipeRepository.findAll()).thenReturn(recipeList);

  assertEquals(recipeList.size(), recipeService.getAllRecipes().size());


  }

  @Test
  public void returnRecipeByID_whenGiveItAListOfRecipes(){
    List<Recipe> recipeList = new ArrayList<>();

    List<Ingredients> mackerelIngredients = new ArrayList<>();
    mackerelIngredients.add(new Ingredients("New Potatoes, halved", "250g"));
    mackerelIngredients.add(new Ingredients("Oil", "2 tbsp"));
    mackerelIngredients.add(new Ingredients("Large Leeks, sliced", "2"));
    mackerelIngredients.add(new Ingredients("Eggs", "4"));
    mackerelIngredients.add(new Ingredients("Horseradish, creamed", "2 tbsp"));

    recipeList.add(new Recipe("1", "Smoked mackerel and leek hash with horseradish", mackerelIngredients, 2, "30 minutes",
        "1. Put the potatoes in a microwaveable bowl with a splash of water, cover, then cook on high for 5 mins until tender (or steam or simmer them). " +
            "2. Meanwhile, heat the oil in a frying pan over a medium heat, add the leeks with a pinch of salt and cook for 10 mins, stirring so they don’t stick, until softened. Tip in the potatoes, turn up the heat and fry for a couple of mins to crisp them up a bit. Flake through the mackerel. " +
            "3. Make four indents in the leek mixture in the pan, crack an egg into each, season, then cover the pan and cook for 6-8 mins until the whites have set and the yolks are runny. Serve the horseradish on the side, with the pan in the middle of the table. "));


    List<Ingredients> blackTahiniIngredients = new ArrayList<>();
    blackTahiniIngredients.add(new Ingredients("Fine Rice Noodles", "150g"));
    blackTahiniIngredients.add(new Ingredients("Limes", "2"));
    blackTahiniIngredients.add(new Ingredients("Punnet of Cress", "1"));
    blackTahiniIngredients.add(new Ingredients("Black Sesame Seeds", "50g"));
    blackTahiniIngredients.add(new Ingredients("Teriyaki Sauce", "2 tbsp"));

    recipeList.add(new Recipe("2", "Black tahini noodles", blackTahiniIngredients, 2, "13 minutes",
        "1. Cook the noodles in boiling salted water according to the packet instructions, then drain, reserving a mugful of cooking water. Meanwhile, finely grate the zest of 1 lime, snip the cress and put both aside. " +
            "2. Toast the sesame seeds in a dry non-stick frying pan on a high heat for 1 minute, tossing regularly. Reserving one quarter of the seeds, pound the rest in a pestle and mortar until fairly fine, then muddle in the teriyaki and the juice of 1 lime. Taste, season to perfection with sea salt and black pepper, and you’ve got a black tahini! " +
            "3. Toss the noodles and black tahini together, loosening with a splash of reserved noodle water. Serve sprinkled with the lime zest, cress and reserved seeds, with lime wedges on the side, for squeezing over."));

    when(recipeRepository.findById("1")).thenReturn(recipeList.stream().findAny());

    assertEquals(recipeList.get(0), recipeService.getRecipeByID("1"));
  }

  @Test
  public void addRecipeToDatabase_whenGivenOneRecipe(){

    List<Ingredients> mackerelIngredients = new ArrayList<>();
    mackerelIngredients.add(new Ingredients("New Potatoes, halved", "250g"));
    mackerelIngredients.add(new Ingredients("Oil", "2 tbsp"));
    mackerelIngredients.add(new Ingredients("Large Leeks, sliced", "2"));
    mackerelIngredients.add(new Ingredients("Eggs", "4"));
    mackerelIngredients.add(new Ingredients("Horseradish, creamed", "2 tbsp"));

    Recipe recipe = mock(Recipe.class);
    recipe.setId("1");
    recipe.setName("Smoked mackerel and leek hash with horseradish");
    recipe.setIngredients(mackerelIngredients);
    recipe.setServing(2);
    recipe.setDuration("30 minutes");
    recipe.setInstructions(" \"1. Put the potatoes in a microwaveable bowl with a splash of water, cover, then cook on high for 5 mins until tender (or steam or simmer them). \" +\n" +
        "            \"2. Meanwhile, heat the oil in a frying pan over a medium heat, add the leeks with a pinch of salt and cook for 10 mins, stirring so they don’t stick, until softened. Tip in the potatoes, turn up the heat and fry for a couple of mins to crisp them up a bit. Flake through the mackerel. \" +\n" +
        "            \"3. Make four indents in the leek mixture in the pan, crack an egg into each, season, then cover the pan and cook for 6-8 mins until the whites have set and the yolks are runny. Serve the horseradish on the side, with the pan in the middle of the table. \");\n");



    when(recipeRepository.save(recipe)).thenReturn(recipe);

    Recipe savedRecipe = recipeService.addRecipe(recipe);

    assertThat(savedRecipe).isNotNull();

  }


}
