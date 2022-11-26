package com.meals.thirtyminutemeals.model;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Ingredients {

  private String name;
  private int quantity;

  public Ingredients(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
