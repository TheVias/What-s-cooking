package com.application.vias.what_s_cooking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Содержит static-поля db-хелпера
 * Created by andrey on 17.04.2016.
 */
public class AbstractDatabaseHelper extends SQLiteOpenHelper {

    //имя базы данных
    protected static final String DATABASE_NAME = "database.db";
    //версия базы данных
    protected static final int DATABASE_VERSION = 1;

    //созданице таблицы Instruction #1
    protected static final String DATABASE_CREATE_SCRIPT1 = "Create table INSTRUCTION ( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "description TEXT NOT NULL, "
            + "timer number(4) NOT NULL, "
            + "image TEXT );";

    //создание таблицы Tag #2
    protected static final String DATABASE_CREATE_SCRIPT2 = "Create table TAG( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL );";

    //Созадние таблицы Foodcategory #3
    protected static final String DATABASE_CREATE_SCRIPT3 = "CREATE table FOODCATEGORY( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL);";

    //Создание таблицы INGREDIENT #4
    protected static final String DATABASE_CREATE_SCRIPT4 = "CREATE table INGREDIENT( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL, "
            + "category INTEGER, "
            + "FOREIGN KEY (category) REFERENCES FOODCATEGORY(_id));";

    //Созадние таблицы Dish #5
    protected static final String DATABASE_CREATE_SCRIPT5 = "CREATE TABLE DISH( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL, "
            + "vote_simple_count INTEGER,"
            + "vote_origin_count INTEGER,"
            + "vote_cashtime_count INTEGER,"
            + "r_simple INTEGER, "
            + "r_origin INTEGER, "
            + "r_cashtime INTEGER, "
            + "date_create TEXT);";

    //Созадние таблицы Dish_INGR #6
    protected static final String DATABASE_CREATE_SCRIPT6 = " CREATE TABLE DISH_INGR("
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "dish INTEGER, "
            + "ingredient INTEGER, "
            + "FOREIGN KEY (dish) REFERENCES DISH(_id), "
            + "FOREIGN KEY (ingredient) REFERENCES INGREDIENT(_id));";

    //Созадние таблицы Dish_INSTR #7
    protected static final String DATABASE_CREATE_SCRIPT7 = "CREATE TABLE DISH_INSTR( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "dish INTEGER, "
            + "instruction_num INTEGER,"
            + "instruction INTEGER, "
            + "FOREIGN KEY (dish) REFERENCES DISH(_id), "
            + "FOREIGN KEY (instruction) REFERENCES INSTRUCTION(_id));";

    //Созадние таблицы Dish_TAG #8
    //названия столбцов

    protected static final String DATABASE_CREATE_SCRIPT8 = "CREATE TABLE DISH_TAG( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "dish INTEGER, "
            + "tag INTEGER,"
            + "FOREIGN KEY (dish) REFERENCES DISH(_id), "
            + "FOREIGN KEY (tag) REFERENCES TAG(_id));";

    //Добавление информации в БД

    //Добавление информации в таблицу INSTRUCTION
    protected static final String DATABASE_INSERT_INSTRUCTION_SCRIPT1 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Варить 10 минут', 1, 'egg.jpg'); ";

    protected static final String DATABASE_INSERT_INSTRUCTION_SCRIPT2 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Почистить картошку, морковку и лук', 0, 'potato.jpg'); ";
    protected static final String DATABASE_INSERT_INSTRUCTION_SCRIPT3 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Порезать кубиками', 0, NULL); ";
    protected static final String DATABASE_INSERT_INSTRUCTION_SCRIPT4 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Жарить на медленном огне 15 минут', 1, 'fry.jpg'); ";
    protected static final String DATABASE_INSERT_INSTRUCTION_SCRIPT5 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Выпекать при температуре 180 градусов в течение часа', 1, 'bake.jpg'); ";

    //Добавление информации в таблицу TAG
    protected static final String DATABASE_INSERT_TAG_SCRIPT1 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Для студентов');";
    protected static final String DATABASE_INSERT_TAG_SCRIPT2 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('На завтрак');";
    protected static final String DATABASE_INSERT_TAG_SCRIPT3 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Быстро');";
    protected static final String DATABASE_INSERT_TAG_SCRIPT4 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Вегетарианское');";
    protected static final String DATABASE_INSERT_TAG_SCRIPT5 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Изи');";

    //Добавление информации в таблицу FOODCATEGORY
    protected static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT1 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Овощи');";
    protected static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT2 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Фрукты');";
    protected static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT3 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Молочные продукты и яйца');";
    protected static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT4 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Бакалея');";
    protected static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT5 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Мясо');";
    protected static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT6 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Рыба');";

    //Добавление информации в таблицу INGREDIENT

    protected static final String DATABASE_INSERT_INGREDIENT_SCRIPT1 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Молоко', 3);";
    protected static final String DATABASE_INSERT_INGREDIENT_SCRIPT2 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Кефир', 3);";
    protected static final String DATABASE_INSERT_INGREDIENT_SCRIPT3 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Форель', 6);";
    protected static final String DATABASE_INSERT_INGREDIENT_SCRIPT4 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Говядина', 5);";
    protected static final String DATABASE_INSERT_INGREDIENT_SCRIPT5 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Свинина', 5);";
    protected static final String DATABASE_INSERT_INGREDIENT_SCRIPT6 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Морковь', 1);";
    protected static final String DATABASE_INSERT_INGREDIENT_SCRIPT7 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Картофель', 1);";

    //Добавление информации в таблицу DISH
    protected static final String DATABASE_INSERT_DISH_SCRIPT1 = "INSERT INTO DISH "
            + "(name, vote_simple_count, vote_origin_count, vote_cashtime_count, r_simple, r_origin,r_cashtime,date_create) "
            + "VALUES ('Жаркое',1,1,1,5,3,4, ' ');";
    protected static final String DATABASE_INSERT_DISH_SCRIPT2 = "INSERT INTO DISH "
            + "(name, vote_simple_count, vote_origin_count, vote_cashtime_count, r_simple, r_origin,r_cashtime,date_create) "
            + "VALUES ('Рыба со сливочным соусом',1,1,1,3,5,2, ' ');";

    //Добавление информации в таблицу DISH_INGR
    protected static final String DATABASE_INSERT_DISH_INGR_SCRIPT1 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (1, 5);";
    protected static final String DATABASE_INSERT_DISH_INGR_SCRIPT2 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (1, 6);";
    protected static final String DATABASE_INSERT_DISH_INGR_SCRIPT3 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (1, 7);";
    protected static final String DATABASE_INSERT_DISH_INGR_SCRIPT4 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (2, 1);";
    protected static final String DATABASE_INSERT_DISH_INGR_SCRIPT5 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (2, 3);";

    //Добавление информации в таблицу DISH_INSTR
    protected static final String DATABASE_INSERT_DISH_INSTR_SCRIPT1 = "INSERT INTO DISH_INSTR "
            + "(dish, instruction, instruction_num) "
            + "VALUES (1,2,0);";
    protected static final String DATABASE_INSERT_DISH_INSTR_SCRIPT2 = "INSERT INTO DISH_INSTR "
            + "(dish, instruction, instruction_num) "
            + "VALUES (1,4,1);";
    protected static final String DATABASE_INSERT_DISH_INSTR_SCRIPT3 = "INSERT INTO DISH_INSTR "
            + "(dish, instruction, instruction_num) "
            + "VALUES (1,1,2);";

    //Добавление информации в таблицу DISH_TAG
    protected static final String DATABASE_INSERT_DISH_TAG_SCRIPT1 = "INSERT INTO DISH_TAG "
            + "(dish, tag) "
            + "VALUES (1,5);";
    protected static final String DATABASE_INSERT_DISH_TAG_SCRIPT2 = "INSERT INTO DISH_TAG "
            + "(dish, tag) "
            + "VALUES (1,1);";
    protected static final String DATABASE_INSERT_DISH_TAG_SCRIPT3 = "INSERT INTO DISH_TAG "
            + "(dish, tag) "
            + "VALUES (2,5);";

    public AbstractDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
