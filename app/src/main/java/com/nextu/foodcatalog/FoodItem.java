package com.nextu.foodcatalog;

/**
 * Created by Next University.
 */

public class FoodItem {

    private String name;

    private String description;

    private String ingredients;

    private String primaryImage;

    public FoodItem(String name, String description, String ingredients, String primaryImage) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.primaryImage = primaryImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
