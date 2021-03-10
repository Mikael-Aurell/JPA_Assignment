package se.lexicon.jpaassignment.entity;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private int id;
    private String name;
    private List<Ingredient> ingredients; //Todo: implement autoremoval of this
    private RecipeInstruction recipeInstruction;
    private List<RecipeCategory> recipeCategories;

    public Recipe() {
    }

    public Recipe(int id, String name, List<Ingredient> ingredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    public Recipe(int id, String name, List<Ingredient> ingredients, RecipeInstruction recipeInstruction) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe(String name, List<Ingredient> ingredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        this.name = name;
        this.ingredients = ingredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && Objects.equals(name, recipe.name) && Objects.equals(ingredients, recipe.ingredients) && Objects.equals(recipeInstruction, recipe.recipeInstruction) && Objects.equals(recipeCategories, recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}
