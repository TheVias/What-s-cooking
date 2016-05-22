package com.application.vias.what_s_cooking.entity;

import android.graphics.Bitmap;

import com.application.vias.what_s_cooking.LocalLoad;

import java.io.Serializable;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class CookingImage implements Serializable{
    private String name;
    private Bitmap image;

    public CookingImage() {
    }

    public CookingImage(String name, Bitmap image) {
        this.name = name;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
