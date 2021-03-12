package se.lexicon.jpaassignment.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpaassignment.entity.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeRepoTest {

    @Autowired
    RecipeRepo testObject;

    Recipe recipe;

    List<Recipe> recipesTest;
    List<RecipeIngredient> recipeIngredientsTest;
    List<RecipeCategory> recipeCategoriesTest;

    @BeforeEach
    public void setup(){

        //Ingredient
        Ingredient testIngredient1 = new Ingredient("Korv");
        Ingredient testIngredient2 = new Ingredient("Grädde");
        Ingredient testIngredient3 = new Ingredient("Ris");
        Ingredient testIngredient4 = new Ingredient("Tomatkross");

        //RecipeIngredient
        RecipeIngredient testRecipeIngredient1 = new RecipeIngredient(testIngredient1,0.8,Measurement.KG, recipe);
        RecipeIngredient testRecipeIngredient2 = new RecipeIngredient(testIngredient2,3.5,Measurement.DL, recipe);
        RecipeIngredient testRecipeIngredient3 = new RecipeIngredient(testIngredient3,4.0,Measurement.DL, recipe);
        RecipeIngredient testRecipeIngredient4 = new RecipeIngredient(testIngredient4,5.0,Measurement.DL, recipe);

        //List of RecipeIngredients
        recipeIngredientsTest = new ArrayList<>();
        recipeIngredientsTest.add(testRecipeIngredient1);
        recipeIngredientsTest.add(testRecipeIngredient2);
        recipeIngredientsTest.add(testRecipeIngredient3);
        recipeIngredientsTest.add(testRecipeIngredient4);

        //RecipeInstruction

        RecipeInstruction recipeInstructionTest1 =
                new RecipeInstruction("Koka riset, stek korven, häll i tomatkross, häll i grädden. Koka 20 min.");

        //RecipeCategory
        RecipeCategory recipeCategoryTest1 = new RecipeCategory("Main", recipesTest);
        //RecipeCategory recipeCategoryTest2 = new RecipeCategory(2, "Side",null);

        //List of RecipeCategories
        recipeCategoriesTest = new ArrayList<>();
        recipeCategoriesTest.add(recipeCategoryTest1);
        //recipeCategoriesTest.add(recipeCategoryTest2);

        //Recipe
        recipe = new Recipe("Korvstroganoff", recipeIngredientsTest, recipeInstructionTest1, recipeCategoriesTest);

        //List of Recipes
        recipesTest = new ArrayList<>();
        recipesTest.add(recipe);

        //Save to RecipeRepo
        testObject.save(recipe);
    }

    @Test
    public void test_successfully_created(){
        assertEquals(1,testObject.findById(1).get().getId());
    }

    @Test
    public void test_find_by_name_contains(){
        assertEquals("Korvstroganoff", testObject.findRecipeByNameContains("gano").get(0).getName());
        //List<Recipe> actual = testObject.findRecipeByNameContains("gano");
        //actual.forEach(System.out::println);
    }

    @Test
    public void find_Ingredient(){
        assertEquals("Korvstroganoff", testObject.findRecipesByRecipeIngredients_Ingredient_Ingredient("Grädde").get(0).getName());
    }

    @Test
    public void find_Category(){
        assertEquals("Korvstroganoff", testObject.findRecipesByRecipeCategories_Category("Main").get(0).getName());
    }

    @Test
    public void find_Recipes_Name(){
        assertEquals("Korvstroganoff", testObject.findRecipesByRecipeCategories_Recipes_Name("Korvstroganoff").get(0).getName());
    }
}
