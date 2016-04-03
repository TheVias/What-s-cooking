package com.application.vias.what_s_cooking;

/**
 * Created by andrey on 03.04.2016.
 */
public class Ingredient {
    private int ingr_id;
    private String name;
    private String category;

    public Ingredient(int ingr_id, String name, String category) {
        this.ingr_id = ingr_id;
        this.name = name;
        this.category = category;
    }

    public Ingredient(int ingr_id, String name) {
        this.ingr_id = ingr_id;
        this.name = name;
    }

    public int getIngr_id() {
        return ingr_id;
    }

    public void setIngr_id(int ingr_id) {
        this.ingr_id = ingr_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
