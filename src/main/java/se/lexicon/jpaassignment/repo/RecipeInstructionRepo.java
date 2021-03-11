package se.lexicon.jpaassignment.repo;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpaassignment.entity.RecipeInstruction;

public interface RecipeInstructionRepo extends CrudRepository<RecipeInstruction, String> {
}
