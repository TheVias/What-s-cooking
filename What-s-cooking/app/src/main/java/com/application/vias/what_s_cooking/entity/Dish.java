package com.application.vias.what_s_cooking.entity;

import android.content.Context;

import com.application.vias.what_s_cooking.ILoadImage;
import com.application.vias.what_s_cooking.LocalLoad;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class Dish implements Serializable {

    private int _id;
    private String name;
    private String date_create;
    private int vote_simple_count,vote_origin_count,vote_cashtime_count;
    private int r_simple, r_origin, r_cashtime;
    private List <Ingredient> ingredients;
    private List<Instruction> instructions;
    private List <Tag> tags;
    private String description;
    private CookingImage image;
    private String image_res;
    private Context context;

    public Dish() {
        image = null;
    }

    public Dish(int _id, String name, String date_create, int vote_simple_count, int vote_origin_count, int vote_cashtime_count, int r_simple, int r_origin, int r_cashtime, List<Ingredient> ingredients, List<Instruction> instructions, List<Tag> tags, String description, CookingImage image) {
        this._id = _id;
        this.name = name;
        this.date_create = date_create;
        this.vote_simple_count = vote_simple_count;
        this.vote_origin_count = vote_origin_count;
        this.vote_cashtime_count = vote_cashtime_count;
        this.r_simple = r_simple;
        this.r_origin = r_origin;
        this.r_cashtime = r_cashtime;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.tags = tags;
        this.description = description;
        this.image = image;
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

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public int getVote_simple_count() {
        return vote_simple_count;
    }

    public void setVote_simple_count(int vote_simple_count) {
        this.vote_simple_count = vote_simple_count;
    }

    public int getVote_origin_count() {
        return vote_origin_count;
    }

    public void setVote_origin_count(int vote_origin_count) {
        this.vote_origin_count = vote_origin_count;
    }

    public int getVote_cashtime_count() {
        return vote_cashtime_count;
    }

    public void setVote_cashtime_count(int vote_cashtime_count) {
        this.vote_cashtime_count = vote_cashtime_count;
    }

    public int getR_simple() {
        return r_simple;
    }

    public void setR_simple(int r_simple) {
        this.r_simple = r_simple;
    }

    public int getR_origin() {
        return r_origin;
    }

    public void setR_origin(int r_origin) {
        this.r_origin = r_origin;
    }

    public int getR_cashtime() {
        return r_cashtime;
    }

    public void setR_cashtime(int r_cashtime) {
        this.r_cashtime = r_cashtime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getRate_simple(){
        return r_simple/vote_simple_count;
    }

    public int getRate_origin(){
        return r_origin/vote_origin_count;
    }

    public int getRate_cashtime(){
        return r_cashtime/vote_cashtime_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CookingImage getImage() {
        return image;
    }

    public void setImage(CookingImage image) {
        this.image = image;
    }

    public String getImage_res() {
        return image_res;
    }

    public void setImage_res(String image_res) {
        this.image_res = image_res;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
