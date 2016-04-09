package com.application.vias.what_s_cooking;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class Instruction {

    private String description;
    private CookingTimer timer;
    private CookingImage image;
    private boolean wasLooked;

    public Instruction(String description, CookingTimer timer, CookingImage image){
        this.description = description;
        this.timer = timer;
        this.image = image;
        wasLooked = false;
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
}
