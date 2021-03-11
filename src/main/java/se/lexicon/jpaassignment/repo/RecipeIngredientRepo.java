package se.lexicon.jpaassignment.repo;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpaassignment.entity.RecipeIngredient;

public interface RecipeIngredientRepo extends CrudRepository<RecipeIngredient, String> {
}
