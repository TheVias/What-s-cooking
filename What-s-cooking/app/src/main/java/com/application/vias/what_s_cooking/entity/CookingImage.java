package com.application.vias.what_s_cooking.entity;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.Serializable;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class CookingImage implements Serializable{
    private String name;
    private String placeholder;
    private Bitmap image;

    public CookingImage() {
    }

    public CookingImage(String name, String placeholder, Bitmap image) {
        this.name = name;
        this.placeholder = placeholder;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
