package com.application.vias.what_s_cooking;

/**
 * Класс-ингредиент. Содержит все необходимые поля ингредиента, сеттеры и геттеры.
 */
public class Ingredient {
    private int _id;
    private int category;
    private String name;

    public Ingredient(int _id, String name, int category) {
        this._id = _id;
        this.name = name;
        this.category = category;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public int getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (!this.getClass().equals(o.getClass())) {
            return false;
        }

        Ingredient ingredient = (Ingredient)o;
        if (this.get_id() != ingredient.get_id()) {
            return false;
        }
        if (!this.getName().equals(ingredient.getName())) {
            return false;
        }
        if (this.getCategory() != ingredient.getCategory()) {
            return false;
        }
        return true;
    }
}
