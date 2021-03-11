package se.lexicon.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    Recipe testObject;
    Recipe recipeTest1;
    Recipe recipeTest2;

    String uuidTest1;
    String uuidTest2;
    String uuidTest3;

    RecipeInstruction recipeInstructionTest1;
    RecipeInstruction recipeInstructionTest2;
    RecipeInstruction recipeInstructionTest3;

    List<Recipe> recipesTest;
    List<RecipeIngredient> recipeIngredientsTest;
    List<RecipeCategory> recipeCategoriesTest;


    @BeforeEach
    public void setup(){

        testObject = new Recipe();

        //Ingredient
        Ingredient testIngredient1 = new Ingredient(1,"Sugar");
        Ingredient testIngredient2 = new Ingredient(2,"Salt");

        //RecipeIngredient
        RecipeIngredient testRecipeIngredient1 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient1,5.0,Measurement.CL, recipeTest1);
        RecipeIngredient testRecipeIngredient2 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient2,3.5,Measurement.DL,recipeTest2);

        //List of RecipeIngredients
        recipeIngredientsTest = new ArrayList<>();
        recipeIngredientsTest.add(testRecipeIngredient1);
        recipeIngredientsTest.add(testRecipeIngredient2);

        //UUID
        uuidTest1 = UUID.randomUUID().toString();
        uuidTest2 = UUID.randomUUID().toString();
        uuidTest3 = UUID.randomUUID().toString();

        //RecipeInstruction
        recipeInstructionTest1 = new RecipeInstruction(uuidTest1,"Instruction1");
        recipeInstructionTest2 = new RecipeInstruction(uuidTest2, "Instruction2");
        recipeInstructionTest3 = new RecipeInstruction(uuidTest3, "Instruction3");

        //RecipeCategory
        RecipeCategory recipeCategoryTest1 = new RecipeCategory(1, "A",recipesTest);
        RecipeCategory recipeCategoryTest2 = new RecipeCategory(2, "B",recipesTest);

        //List of RecipeCategories
        recipeCategoriesTest = new ArrayList<>();
        recipeCategoriesTest.add(recipeCategoryTest1);
        recipeCategoriesTest.add(recipeCategoryTest2);

        //Recipe
        recipeTest1 = new Recipe(1,"Recipe1", recipeIngredientsTest,recipeInstructionTest1,recipeCategoriesTest);
        recipeTest2 = new Recipe(2,"Recipe2", recipeIngredientsTest,recipeInstructionTest2,recipeCategoriesTest);

        //List of Recipes
        recipesTest = new ArrayList<>();
        recipesTest.add(recipeTest1);
        recipesTest.add(recipeTest2);

        testObject = new Recipe(3,"Recipe3", recipeIngredientsTest, recipeInstructionTest3, recipeCategoriesTest);
    }

    @Test
    @DisplayName("Test 1 Create Object")
    public void test_successfully_created(){
        assertEquals(3,testObject.getId());
        assertEquals("Recipe3",testObject.getName());
        assertEquals("Sugar", testObject.getRecipeIngredients().get(0).getIngredient().getIngredient_info());
        assertEquals("Instruction3", testObject.getRecipeInstruction().getInstructions());
        assertEquals("B", testObject.getRecipeCategories().get(1).getCategory());
    }

    @Test
    @DisplayName("Test 2 Equal")
    public void test_equal(){
        Recipe expected = new Recipe(3,"Recipe3", recipeIngredientsTest, recipeInstructionTest3, recipeCategoriesTest);
        assertTrue(expected.equals(testObject));
    }

    @Test
    @DisplayName("Test 3 Hashcode")
    public void test_hashcode(){
        Recipe expected = new Recipe(3,"Recipe3", recipeIngredientsTest, recipeInstructionTest3, recipeCategoriesTest);
        assertEquals(expected.hashCode(),testObject.hashCode());
    }
}
