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
    RecipeIngredient testRecipeIngredient1;
    RecipeIngredient testRecipeIngredient2;

    Recipe recipeTest1;
    Recipe recipeTest2;

    List<Recipe> recipesTest;
    List<RecipeIngredient> recipeIngredientsTest;
    List<RecipeCategory> recipeCategories;

    @BeforeEach
    public void setup(){

        Ingredient testIngredient1 = new Ingredient(1,"Sugar");
        Ingredient testIngredient2 = new Ingredient(2,"Salt");

        //RecipeIngredient
        testRecipeIngredient1 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient1,5.0,Measurement.CL, recipeTest1);
        testRecipeIngredient2 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient2,3.5,Measurement.DL, recipeTest2);

        //List of RecipeIngredients
        recipeIngredientsTest = new ArrayList<>();
        recipeIngredientsTest.add(testRecipeIngredient1);
        recipeIngredientsTest.add(testRecipeIngredient2);

        String uuidTest1 = UUID.randomUUID().toString();
        String uuidTest2 = UUID.randomUUID().toString();
        RecipeInstruction recipeInstructionTest1 = new RecipeInstruction(uuidTest1,"TestString1");
        RecipeInstruction recipeInstructionTest2 = new RecipeInstruction(uuidTest2,"TestString2");



        recipeTest1 = new Recipe(1,"testName1", recipeIngredientsTest, recipeInstructionTest1);
        recipeTest2 = new Recipe(2,"testName2", recipeIngredientsTest, recipeInstructionTest2);
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
