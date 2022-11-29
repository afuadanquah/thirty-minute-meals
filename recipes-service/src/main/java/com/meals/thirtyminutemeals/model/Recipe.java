package com.meals.thirtyminutemeals.model;

import java.util.List;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Recipe {

  @PrimaryKey
  private String id;
  private String name;
  private List<Ingredients> ingredients;
  private int serving;
  private String duration;
  private String instructions;

  public Recipe(String id, String name, List<Ingredients> ingredients, int serving, String duration,
                String instructions) {
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
    this.serving = serving;
    this.duration = duration;
    this.instructions = instructions;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Ingredients> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredients> ingredients) {
    this.ingredients = ingredients;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getServing() {
    return serving;
  }

  public void setServing(int serving) {
    this.serving = serving;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }
}
