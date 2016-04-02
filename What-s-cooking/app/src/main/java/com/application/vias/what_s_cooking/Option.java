package com.application.vias.what_s_cooking;

import android.util.EventLogTags;

/**
 * Created by andrey on 02.04.2016.
 */
public class Option {

    private int id;
    private String title;
    private String description;

    public Option(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
