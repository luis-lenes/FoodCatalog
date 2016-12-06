package com.nextu.foodcatalog;

/**
 * Created by Next University.
 */

public class FoodItem {

    private String name;

    private String description;

    private String image;

    private FoodType foodType;

    public FoodItem(String description, String image, String name, FoodType foodType) {
        this.description = description;
        this.foodType = foodType;
        this.image = image;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
}
