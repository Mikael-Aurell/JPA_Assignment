package se.lexicon.jpaassignment.entity;

import java.util.Objects;

public class Ingredient {
    private int id;
    private String ingredient_info; //Todo: unique

    public Ingredient() {
    }

    public Ingredient(int id, String ingredient_info) {
        this.id = id;
        this.ingredient_info = ingredient_info;
    }

    public Ingredient(String ingredient_info) {
        this.ingredient_info = ingredient_info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredient_info() {
        return ingredient_info;
    }

    public void setIngredient_info(String ingredient_info) {
        this.ingredient_info = ingredient_info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && Objects.equals(ingredient_info, that.ingredient_info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient_info);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredient_info='" + ingredient_info + '\'' +
                '}';
    }
}
