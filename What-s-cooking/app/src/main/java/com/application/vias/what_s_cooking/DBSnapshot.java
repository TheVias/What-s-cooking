package com.application.vias.what_s_cooking;

import java.io.Serializable;

/**
 * Created by andrey on 17.04.2016.
 */
public class DBSnapshot implements Serializable{
    private int[] ingredient;
    private int[] category;
    private int[] dish;
    private int[] instruction;
    private int[] tag;
    private int[] dish_ingr;
    private int[] dish_instr;
    private int[] dish_tag;

    public DBSnapshot () {
        ingredient = null;
        category = null;
        dish = null;
        instruction = null;
        tag = null;
        dish_ingr = null;
        dish_instr = null;
        dish_tag = null;
    }

    public int[] getDish_ingr() {
        return dish_ingr;
    }

    public void setDish_ingr(int[] dish_ingr) {
        this.dish_ingr = dish_ingr;
    }

    public int[] getDish_instr() {
        return dish_instr;
    }

    public void setDish_instr(int[] dish_instr) {
        this.dish_instr = dish_instr;
    }

    public int[] getDish_tag() {
        return dish_tag;
    }

    public void setDish_tag(int[] dish_tag) {
        this.dish_tag = dish_tag;
    }

    public int[] getInstruction() {
        return instruction;
    }

    public void setInstruction(int[] instruction) {
        this.instruction = instruction;
    }

    public int[] getCategory() {
        return category;
    }

    public void setCategory(int[] category) {
        this.category = category;
    }

    public int[] getDish() {
        return dish;
    }

    public void setDish(int[] dish) {
        this.dish = dish;
    }

    public int[] getIngredient() {
        return ingredient;
    }

    public void setIngredient(int[] ingredient) {
        this.ingredient = ingredient;
    }

    public int[] getTag() {
        return tag;
    }

    public void setTag(int[] tag) {
        this.tag = tag;
    }
}
