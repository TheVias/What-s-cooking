package com.application.vias.what_s_cooking;

import java.io.Serializable;
import java.util.Set;

/**
 * Класс-снимок айдюков базы
 * Created by andrey on 17.04.2016.
 */
public class DBSnapshot implements Serializable {

    //штука, которая нужна serializable для проверки на равенство версий классов
    private static final long serialVersionUID = 1L;

    private Set<Integer> ingredient;
    private Set<Integer> category;
    private Set<Integer> dish;
    private Set<Integer> instruction;
    private Set<Integer> tag;
    private Set<Integer> dish_ingr;
    private Set<Integer> dish_instr;
    private Set<Integer> dish_tag;

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

    public Set<Integer> getIngredient() {
        return ingredient;
    }

    public void setIngredient(Set<Integer> ingredient) {
        this.ingredient = ingredient;
    }

    public Set<Integer> getCategory() {
        return category;
    }

    public void setCategory(Set<Integer> category) {
        this.category = category;
    }

    public Set<Integer> getDish() {
        return dish;
    }

    public void setDish(Set<Integer> dish) {
        this.dish = dish;
    }

    public Set<Integer> getInstruction() {
        return instruction;
    }

    public void setInstruction(Set<Integer> instruction) {
        this.instruction = instruction;
    }

    public Set<Integer> getTag() {
        return tag;
    }

    public void setTag(Set<Integer> tag) {
        this.tag = tag;
    }

    public Set<Integer> getDish_ingr() {
        return dish_ingr;
    }

    public void setDish_ingr(Set<Integer> dish_ingr) {
        this.dish_ingr = dish_ingr;
    }

    public Set<Integer> getDish_instr() {
        return dish_instr;
    }

    public void setDish_instr(Set<Integer> dish_instr) {
        this.dish_instr = dish_instr;
    }

    public Set<Integer> getDish_tag() {
        return dish_tag;
    }

    public void setDish_tag(Set<Integer> dish_tag) {
        this.dish_tag = dish_tag;
    }

    public void removeAll(DBSnapshot snapshot) {
        ingredient.removeAll(snapshot.getIngredient());
        category.removeAll(snapshot.getCategory());
        dish.removeAll(snapshot.getDish());
        instruction.removeAll(snapshot.getInstruction());
        tag.removeAll(snapshot.getTag());
        dish_ingr.removeAll(snapshot.getDish_ingr());
        dish_instr.removeAll(snapshot.getDish_instr());
        dish_tag.removeAll(snapshot.getDish_tag());
    }

}