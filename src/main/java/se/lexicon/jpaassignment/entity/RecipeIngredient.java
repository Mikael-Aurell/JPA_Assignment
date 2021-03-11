package se.lexicon.jpaassignment.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name ="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private double measured_amount;

    private Measurement measurement;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(String id, Ingredient ingredient, double measured_amount, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.ingredient = ingredient;
        this.measured_amount = measured_amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredient(Ingredient ingredient, double measured_amount, Measurement measurement, Recipe recipe) {
        this.ingredient = ingredient;
        this.measured_amount = measured_amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getMeasured_amount() {
        return measured_amount;
    }

    public void setMeasured_amount(double measured_amount) {
        this.measured_amount = measured_amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.measured_amount, measured_amount) == 0 && Objects.equals(id, that.id) && Objects.equals(ingredient, that.ingredient) && measurement == that.measurement && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient, measured_amount, measurement, recipe);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", ingredient=" + ingredient +
                ", measured_amount=" + measured_amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}
