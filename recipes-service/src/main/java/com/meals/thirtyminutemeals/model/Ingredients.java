package com.meals.thirtyminutemeals.model;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Ingredients {

  private String name;
  private String quantity;

  public Ingredients(String name, String quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
}
