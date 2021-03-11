package se.lexicon.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    Ingredient testObject;
    String ingredient_info;

    @BeforeEach
    public void setup(){
        ingredient_info = "Aqua, Sorbitol, Hydrated Silica, Glycerin, Potassium Nitrate, Cocamidopropyl Betaine";
        testObject = new Ingredient(1,ingredient_info);
    }

    @Test
    @DisplayName("Test 1 Created Object")
    public void test_successfully_created(){
    assertEquals(1, testObject.getId());
    assertEquals(ingredient_info, testObject.getIngredient());
    }

    @Test
    @DisplayName("Test 2 Equal")
    public void test_equal(){
        Ingredient expected = new Ingredient(1,ingredient_info);
        assertTrue(testObject.equals(expected));
    }

    @Test
    @DisplayName("Test 3 Hashcode")
    public void test_hashcode(){
        Ingredient expected = new Ingredient(1,ingredient_info);
        assertEquals(expected.hashCode(),testObject.hashCode());
    }
}
