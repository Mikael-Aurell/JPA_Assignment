package se.lexicon.jpaassignment.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpaassignment.entity.Ingredient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientRepoTest {

    @Autowired
    IngredientRepo testObject;

    Ingredient ingredient;

    @BeforeEach
    public void setup(){
        ingredient = new Ingredient(1,"Potato");
        testObject.save(ingredient);
    }

    @Test
    public void test_find_by_id(){
        assertEquals(1, testObject.findById(1).get().getId());
        assertEquals("Potato", testObject.findById(1).get().getIngredient());
    }

    @Test
    public void test_find_by_ingredient_info(){
        Optional<Ingredient> findIngredient = testObject.findIngredientByIngredient("Potato");
        assertTrue(findIngredient.isPresent());
        assertEquals("Potato", findIngredient.get().getIngredient());
    }
}
