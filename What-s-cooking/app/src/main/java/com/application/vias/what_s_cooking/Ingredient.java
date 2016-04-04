package com.application.vias.what_s_cooking;

/**
 * Класс-ингредиент. Содержит все необходимые поля ингредиента, сеттеры и геттеры.
 */
public class Ingredient {
    private int ingr_id;
    private int category;
    private String name;

    public Ingredient(int ingr_id, String name, int category) {
        this.ingr_id = ingr_id;
        this.name = name;
        this.category = category;
    }

    public int getIngr_id() {
        return ingr_id;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }
}
