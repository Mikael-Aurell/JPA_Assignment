package se.lexicon.jpaassignment.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpaassignment.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeRepoTest {

    @Autowired
    RecipeRepo testObject;


    Recipe recipe;





    /*Recipe recipeTest2;

    String uuidTest1;
    String uuidTest2;
    String uuidTest3;

    RecipeInstruction recipeInstructionTest1;
    RecipeInstruction recipeInstructionTest2;
    RecipeInstruction recipeInstructionTest3;
    */
    List<Recipe> recipesTest;
    List<RecipeIngredient> recipeIngredientsTest;
    List<RecipeCategory> recipeCategoriesTest;

    @BeforeEach
    public void setup(){


        //Ingredient
        Ingredient testIngredient1 = new Ingredient(1,"Korv");
        Ingredient testIngredient2 = new Ingredient(2,"Grädde");
        Ingredient testIngredient3 = new Ingredient(3,"Ris");
        Ingredient testIngredient4 = new Ingredient(4,"Tomatkross");

        //RecipeIngredient*/
        RecipeIngredient testRecipeIngredient1 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient1,0.8,Measurement.KG, recipe);
        RecipeIngredient testRecipeIngredient2 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient2,3.5,Measurement.DL,recipe);
        RecipeIngredient testRecipeIngredient3 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient3,4.0,Measurement.DL,recipe);
        RecipeIngredient testRecipeIngredient4 = new RecipeIngredient(UUID.randomUUID().toString(),testIngredient4,5.0,Measurement.DL,recipe);


        //List of RecipeIngredients
        recipeIngredientsTest = new ArrayList<>();
        recipeIngredientsTest.add(testRecipeIngredient1);
        recipeIngredientsTest.add(testRecipeIngredient2);
        recipeIngredientsTest.add(testRecipeIngredient3);
        recipeIngredientsTest.add(testRecipeIngredient4);

        /*
        //UUID
        uuidTest1 = UUID.randomUUID().toString();
        uuidTest2 = UUID.randomUUID().toString();
        uuidTest3 = UUID.randomUUID().toString();

        //RecipeInstruction*/
        RecipeInstruction recipeInstructionTest1 = new RecipeInstruction(UUID.randomUUID().toString(),"Koka riset, stek korven, häll i tomatkross, häll i grädden. Koka 20 min.");
        //recipeInstructionTest2 = new RecipeInstruction(uuidTest2, "Instruction2");
        //recipeInstructionTest3 = new RecipeInstruction(uuidTest3, "Instruction3");


        //RecipeCategory
        RecipeCategory recipeCategoryTest1 = new RecipeCategory(1, "A",recipesTest);
        //RecipeCategory recipeCategoryTest2 = new RecipeCategory(2, "B",recipesTest);

        //List of RecipeCategories
        recipeCategoriesTest = new ArrayList<>();
        recipeCategoriesTest.add(recipeCategoryTest1);
        //recipeCategoriesTest.add(recipeCategoryTest2);

        //Recipe
        //recipeTest1 = new Recipe(1,"Korvstroganoff", recipeIngredientsTest,recipeInstructionTest1,recipeCategoriesTest);
        //Recipe recipeTest2 = new Recipe(2,"Recipe2", recipeIngredientsTest,recipeInstructionTest2,recipeCategoriesTest);

        //List of Recipes
        recipesTest = new ArrayList<>();
        recipesTest.add(recipe);
        //recipesTest.add(recipeTest2);


        //testObject.saveAll(recipesTest);

        recipe = new Recipe(1,"Korvstroganoff",recipeIngredientsTest,recipeInstructionTest1,null);
        testObject.save(recipe);
    }

    @Test
    public void test_successfully_created(){
        assertEquals(1, testObject.findById(1).get().getId());
    }

    @Test
    public void test_find_by_name_contains(){
        assertEquals("Korv", testObject.findRecipeByName("Korv"));
    }
}
