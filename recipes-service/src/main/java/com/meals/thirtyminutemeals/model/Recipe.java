package com.meals.thirtyminutemeals.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Recipe {

  @PrimaryKey
  private String id;
  private String name;
  private String ingredients;
  private int serves;
  private int duration;
  private String instructions;

  public Recipe(String id, String name, String ingredients, int serves, int duration,
                String instructions) {
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
    this.serves = serves;
    this.duration = duration;
    this.instructions = instructions;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public int getServes() {
    return serves;
  }

  public void setServes(int serves) {
    this.serves = serves;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }
}
