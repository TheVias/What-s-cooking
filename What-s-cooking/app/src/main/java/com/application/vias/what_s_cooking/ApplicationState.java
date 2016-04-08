package com.application.vias.what_s_cooking;

import android.app.Application;

import com.application.vias.what_s_cooking.activity.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-приложение. Помимо прочего являет собой singleton. Используется для хранения параметров
 * и объектов сессии.
 */
public class ApplicationState extends Application {
    private String name;
    private DatabaseHelper helper;
    private List<Ingredient> ingredientList;
    private static ApplicationState singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        singleton.setHelper(new DatabaseHelper(this));
        singleton.setIngredientList(new ArrayList<Ingredient>());
        singleton.setName("Пользователь");
    }

    /**
     * Получение singleton-а
     * @return sigleton
     */
    static public ApplicationState getInstance(){
        return singleton;
    }

    public DatabaseHelper getHelper() {
        return helper;
    }

    public void setHelper(DatabaseHelper helper) {
        this.helper = helper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
