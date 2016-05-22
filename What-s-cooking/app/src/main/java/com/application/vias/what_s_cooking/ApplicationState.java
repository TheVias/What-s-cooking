package com.application.vias.what_s_cooking;

import android.app.Application;

import com.application.vias.what_s_cooking.entity.Dish;
import com.application.vias.what_s_cooking.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-приложение. Помимо прочего являет собой singleton. Используется для хранения параметров
 * и объектов сессии.
 */
public class ApplicationState extends Application {
    volatile private static ApplicationState singleton;
    volatile private String name;
    volatile private DatabaseHelper helper;
    volatile private List<Ingredient> ingredientList;
    volatile private Dish dish;
    volatile private int instructionNumber;
    volatile private String serverIp;
    volatile private int serverPort;
    volatile private int cookingTime;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        singleton.setHelper(new DatabaseHelper(this));
        singleton.setIngredientList(new ArrayList<Ingredient>());
        singleton.setDish(null);
        singleton.setInstructionNumber(-1);
        singleton.setName("Пользователь");
        singleton.setServerIp("37.139.43.119");
        singleton.setServerPort(6666);
        singleton.setCookingTime(-1);
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

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getInstructionNumber() {
        return instructionNumber;
    }

    public void setInstructionNumber(int instructionNumber) {
        this.instructionNumber = instructionNumber;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
}
