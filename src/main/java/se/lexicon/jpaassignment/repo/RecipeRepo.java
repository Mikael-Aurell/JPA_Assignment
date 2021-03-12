package se.lexicon.jpaassignment.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.jpaassignment.entity.Recipe;

import java.util.List;

public interface RecipeRepo extends CrudRepository<Recipe, Integer>{

List<Recipe> findRecipeByNameContains(String name);

List<Recipe> findRecipesByRecipeIngredients_Ingredient_Ingredient(String ingredient);

List<Recipe> findRecipesByRecipeCategories_Category(String category);

List<Recipe> findRecipesByRecipeCategories_Recipes_Name(String name);

}
