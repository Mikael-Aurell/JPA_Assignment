package se.lexicon.jpaassignment.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpaassignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepo extends CrudRepository<Ingredient,Integer> {

     /*All CRUD here
    saveAll
    findById
    existById
    findAll
    deleteById
    delete
    deleteAll
    */

    Optional<Ingredient> findIngredientByIngredient(String ingredient);
    List<Ingredient> findIngredientByIngredientContains(String ingredient);

}
