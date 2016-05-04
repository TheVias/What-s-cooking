package com.application.vias.what_s_cooking.entity;

import com.application.vias.what_s_cooking.entity.CookingImage;
import com.application.vias.what_s_cooking.entity.CookingTimer;

import java.io.Serializable;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class Instruction implements Serializable{

    private int _id;
    private String description;
    private CookingTimer timer;
    private CookingImage image;
    private boolean wasLooked;
    private int instruction_num;

    public Instruction(){
    }

    public Instruction(String description, CookingTimer timer, CookingImage image, int instruction_num){
        this.description = description;
        this.timer = timer;
        this.image = image;
        wasLooked = false;
        this.instruction_num = instruction_num;
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

    public CookingTimer getTimer() {
        return timer;
    }

    public void setTimer(CookingTimer timer) {
        this.timer = timer;
    }

    public CookingImage getImage() {
        return image;
    }

    public void setImage(CookingImage image) {
        this.image = image;
    }

    public boolean isWasLooked() {
        return wasLooked;
    }

    public void setWasLooked(boolean wasLooked) {
        this.wasLooked = wasLooked;
    }

    public int getInstruction_num() {
        return instruction_num;
    }

    public void setInstruction_num(int instruction_num) {
        this.instruction_num = instruction_num;
    }

}
