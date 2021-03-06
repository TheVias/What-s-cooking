package com.application.vias.what_s_cooking.enums;

/**
 * Класс-перечисление для хранения информации об entity-классах приложения
 */
public enum DBColumn {
    INGREDIENT("ingredient",new String[] {"_id","name","category"}),
    CATEGORY("foodcategory",new String[] {"_id","name"}),
    DISH("dish", new String[] {"_id", "name", "vote_simple_count", "vote_origin_count", "vote_cashtime_count", "r_simple", "r_origin", "r_cashtime", "date_create", "description","image"}),
    INSTRUCTION("instruction", new String[] {"_id","description", "timer", "image"}),
    TAG("tag", new String[] {"_id","name"}),
    DISH_INGR("dish_ingr",new String[] {"_id","dish","ingredient"}),
    DISH_INSTR("dish_instr",new String[] {"_id","dish","instruction","instruction_num"}),
    DISH_TAG("dish_tag",new String[] {"_id","dish","tag"}),
    FAVORITE("favorite",new String[] {"_id","dish"});

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
