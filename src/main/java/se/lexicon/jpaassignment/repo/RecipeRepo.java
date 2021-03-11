package se.lexicon.jpaassignment.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.jpaassignment.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepo extends CrudRepository<Recipe, Integer> {

    @Query("select r from Recipe r where r.name like '%name%'")
    List<Recipe> findRecipeByName (@Param("name")String name);

}
