package com.meals.thirtyminutemeals.repository;

import com.meals.thirtyminutemeals.model.Recipe;
import java.util.List;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CassandraRepository<Recipe, String> {
  @Query("SELECT * FROM meals.recipe")
  List<Recipe> findAll();
}
