package com.application.vias.what_s_cooking.entity;

import java.io.Serializable;

/**
 * Класс-ингредиент. Содержит все необходимые поля ингредиента, сеттеры и геттеры.
 */
public class Ingredient implements Serializable{
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

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
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