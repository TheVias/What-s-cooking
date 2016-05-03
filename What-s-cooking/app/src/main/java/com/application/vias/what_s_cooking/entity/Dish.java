package com.application.vias.what_s_cooking.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class Dish implements Serializable {

    private int _id;
    private String name;
    private Date date_create;
    private double r_simple, r_origin, r_cashtime;
    private LinkedList <Ingredient> ingredients;
    private LinkedList <Instruction> instructions;
    private LinkedList <Tag> tags;

    public Dish() {}

    public Dish(int _id, String name, Date date_create, double r_simple, double r_origin, double r_cashtime, LinkedList<Ingredient> ingredients, LinkedList<Instruction> instructions, LinkedList<Tag> tags) {
        this._id = _id;
        this.name = name;
        this.date_create = date_create;
        this.r_simple = r_simple;
        this.r_origin = r_origin;
        this.r_cashtime = r_cashtime;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.tags = tags;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public double getR_simple() {
        return r_simple;
    }

    public void setR_simple(double r_simple) {
        this.r_simple = r_simple;
    }

    public double getR_origin() {
        return r_origin;
    }

    public void setR_origin(double r_origin) {
        this.r_origin = r_origin;
    }

    public double getR_cashtime() {
        return r_cashtime;
    }

    public void setR_cashtime(double r_cashtime) {
        this.r_cashtime = r_cashtime;
    }

    public LinkedList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(LinkedList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public LinkedList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(LinkedList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public LinkedList<Tag> getTags() {
        return tags;
    }

    public void setTags(LinkedList<Tag> tags) {
        this.tags = tags;
    }
}
