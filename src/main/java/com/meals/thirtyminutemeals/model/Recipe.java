package com.meals.thirtyminutemeals.model;

public class Recipe {

  private String name;
  private String ingredients;
  private int serves;
  private int duration;
  private String instructions;

  public Recipe(String name, String ingredients, int serves, int duration,
                String instructions) {
    this.name = name;
    this.ingredients = ingredients;
    this.serves = serves;
    this.duration = duration;
    this.instructions = instructions;
  }


}
