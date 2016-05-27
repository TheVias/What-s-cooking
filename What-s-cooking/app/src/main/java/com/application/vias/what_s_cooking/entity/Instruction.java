package com.application.vias.what_s_cooking.entity;

import java.io.Serializable;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class Instruction implements Serializable{

    private int _id;
    private String description;
    private int timer;
    private CookingImage image;
    private int instruction_num;

    public Instruction(){
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public int getInstruction_num() {
        return instruction_num;
    }

    public void setInstruction_num(int instruction_num) {
        this.instruction_num = instruction_num;
    }

}
