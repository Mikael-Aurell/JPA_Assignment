package se.lexicon.jpaassignment.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class RecipeCategoryTest {
    RecipeCategory testObject;
    List<RecipeCategory> testCategories;

    @BeforeEach
    public void setup(){

        RecipeCategory testObjectA = new RecipeCategory(1,"A", null);
        RecipeCategory testObjectB = new RecipeCategory(2,"B", null);
        testCategories = new ArrayList<>();
        testCategories.add(testObjectA);
        testCategories.add(testObjectB);
        testObject = new RecipeCategory(3, "C", testCategories);
    }

    @Test
    @DisplayName("Test1 Created Object")
    public void test_successfully_created(){
        assertEquals(3, testObject.getId());
        assertEquals("C",testObject.getCategory());
        assertEquals("A", testObject.getCategories().get(0).getCategory());
    }

    @Test
    @DisplayName("Test2 Equal")
    public void test_equal(){
        RecipeCategory expected = new RecipeCategory(3, "C", testCategories);
        assertTrue(testObject.equals(expected));
    }

    @Test
    @DisplayName("Test3 Hashcode")
    public void test_hashcode(){
        RecipeCategory expected = new RecipeCategory(3, "C", testCategories);
        assertEquals(expected.hashCode(),testObject.hashCode());
    }
}
