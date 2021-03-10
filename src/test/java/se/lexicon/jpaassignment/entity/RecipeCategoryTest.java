package se.lexicon.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RecipeCategoryTest {
    RecipeCategory testObject;
    List<Recipe> recipesTest;
    List<Ingredient> ingredientsTest;
    List<RecipeCategory> recipeCategories;

    @BeforeEach
    public void setup(){

        Ingredient testIngredient1 = new Ingredient(1,"Sugar");
        Ingredient testIngredient2 = new Ingredient(2,"Salt");
        ingredientsTest = new ArrayList<>();
        ingredientsTest.add(testIngredient1);
        ingredientsTest.add(testIngredient2);

        UUID uuidTest1 = UUID.randomUUID();
        UUID uuidTest2 = UUID.randomUUID();
        RecipeInstruction recipeInstructionTest1 = new RecipeInstruction(uuidTest1,"TestString1");
        RecipeInstruction recipeInstructionTest2 = new RecipeInstruction(uuidTest2,"TestString2");

        Recipe recipeTest1 = new Recipe(1,"testName1", ingredientsTest, recipeInstructionTest1);
        Recipe recipeTest2 = new Recipe(2,"testName2", ingredientsTest, recipeInstructionTest2);
        recipesTest = new ArrayList<>();
        recipesTest.add(recipeTest1);
        recipesTest.add(recipeTest2);

        testObject = new RecipeCategory(1,"C",recipesTest);
    }

    @Test
    @DisplayName("Test1 Created Object")
    public void test_successfully_created(){
        assertEquals(1, testObject.getId());
        assertEquals("C",testObject.getCategory());
        assertEquals("testName1", testObject.getRecipes().get(0).getName());
        assertEquals(2, recipesTest.size());
    }

    @Test
    @DisplayName("Test2 Equal")
    public void test_equal(){
        RecipeCategory expected = new RecipeCategory(1, "C", recipesTest);
        assertTrue(testObject.equals(expected));
    }

    @Test
    @DisplayName("Test3 Hashcode")
    public void test_hashcode(){
        RecipeCategory expected = new RecipeCategory(1, "C", recipesTest);
        assertEquals(expected.hashCode(),testObject.hashCode());
    }
}
