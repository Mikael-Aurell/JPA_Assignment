package se.lexicon.jpaassignment.entity;

import java.util.List;
import java.util.Objects;

public class RecipeCategory {
    private int id;
    private String category;
    private List<RecipeCategory> categories;

    public RecipeCategory() {
    }

    public RecipeCategory(int id, String category, List<RecipeCategory> categories) {
        this.id = id;
        this.category = category;
        this.categories = categories;
    }

    public RecipeCategory(String category, List<RecipeCategory> categories) {
        this.category = category;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return id == that.id && Objects.equals(category, that.category) && Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, categories);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", categories=" + categories +
                '}';
    }
}
