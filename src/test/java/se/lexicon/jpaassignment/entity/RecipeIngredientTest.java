package se.lexicon.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeIngredientTest {
    RecipeIngredient testObject;
    Ingredient ingredientTest;
    String uuidTest;

    @BeforeEach
    public void setup(){
        ingredientTest = new Ingredient(1,"sugar");

        testObject = new RecipeIngredient(ingredientTest,5,Measurement.CL,null);
        uuidTest = UUID.randomUUID().toString();
        testObject.setId(uuidTest);
    }

    @Test
    @DisplayName("Test1 Created Object")
    public void test_successfully_created(){
        assertEquals(uuidTest, testObject.getId());
        assertEquals(ingredientTest.getIngredient_info(),testObject.getIngredient().getIngredient_info());
        assertEquals(5,testObject.getMeasured_amount());
        assertEquals(4,testObject.getMeasurement().getTypeCode());
        assertNull(testObject.getRecipe());

        assertEquals(5,testObject.getMeasured_amount());
    }

    @Test
    @DisplayName("Test2 Equal")
    public void test_equal(){
        RecipeIngredient expected = new RecipeIngredient(uuidTest,ingredientTest, 5, Measurement.CL, null);

        assertTrue(testObject.equals(expected));
    }

    @Test
    @DisplayName("Test3 Hashcode")
    public void test_hashcode(){
        RecipeIngredient expected = new RecipeIngredient(uuidTest,ingredientTest, 5, Measurement.CL, null);
        assertEquals(expected.hashCode(),testObject.hashCode());
    }

}
