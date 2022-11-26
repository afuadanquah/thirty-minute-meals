package com.meals.thirtyminutemeals.model;

import java.util.ArrayList;
import java.util.List;
import jnr.ffi.annotations.In;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Recipe {

  @PrimaryKey
  private String id;
  private String name;
  private List<Ingredients> ingredients;
  private int serves;
  private int duration;
  private String instructions;

  public Recipe(String id, String name, List<Ingredients> ingredients, int serves, int duration,
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
