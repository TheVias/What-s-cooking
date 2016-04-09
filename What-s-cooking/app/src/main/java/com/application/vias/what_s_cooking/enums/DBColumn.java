package com.application.vias.what_s_cooking.enums;

/**
 * Класс-перечисление для хранения информации об entity-классах приложения
 */
public enum DBColumn {
    INGREDIENT("ingredient",new String[] {"_id","name","category"}),
    CATEGORY("foodcategory",new String[] {"_id","name"}),
    TAG("tag", new String[] {"_id","name"}),
    INSTRUCTION("instruction", new String[] {"_id","description", "timer", "image"}),
    DISH("dish", new String[] {"_id", "name", "r_simple", "r_origin", "r_cashtime", "date_create"});

    private String[] array;
    private String name;

    DBColumn(String name, String[] array){
        this.name = name;
        this.array = array;
    }

    public String[] getColumns(){
        return array;
    }

    public String getColumn(int i){
        return array[i];
    }

    public String getName(){
        return name;
    }
}
