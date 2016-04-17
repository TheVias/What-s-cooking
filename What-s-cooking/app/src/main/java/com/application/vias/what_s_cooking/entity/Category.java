package com.application.vias.what_s_cooking.entity;

import java.io.Serializable;

/**
 * Created by andrey on 04.04.2016.
 */
public class Category implements Serializable{

    private int _id;
    private String name;

    public Category(int _id, String name) {
        this._id = _id;
        this.name = name;
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

}
