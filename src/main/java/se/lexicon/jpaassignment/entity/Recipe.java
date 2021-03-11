package se.lexicon.jpaassignment.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "recipe_instruction_id", unique = true)
    private RecipeInstruction recipeInstruction;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "recipe_ingredient_id")
    private List<RecipeIngredient> recipeIngredients;

    @ManyToMany
    @JoinTable(name = "recipes_recipe_categories"
        ,joinColumns = @JoinColumn(name = "recipe_id")
        ,inverseJoinColumns = @JoinColumn(name = "recipe_category_id")
    )
    private List<RecipeCategory> recipeCategories;

    public Recipe() {
    }

    public Recipe(int id, String name, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        this.id = id;
        this.name = name;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
    }

    public Recipe(int id, String name, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction) {
        this.id = id;
        this.name = name;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe(String name, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        this.name = name;
        this.recipeIngredients = recipeIngredients;
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

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
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
        return id == recipe.id && Objects.equals(name, recipe.name) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(recipeInstruction, recipe.recipeInstruction) && Objects.equals(recipeCategories, recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, recipeIngredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}
