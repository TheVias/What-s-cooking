package com.application.vias.what_s_cooking.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
/**
 * Класс для создания локальной БД. Тут создаются все таблицы и связи.
 */


/**
 * Created by wesked on 04.04.16.
 */
public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns {

    //имя базы данных
    private static final String DATABASE_NAME = "database.db";
    //версия базы данных
    private static final int DATABASE_VERSION = 1;

    //созданице таблицы Instruction #1
    private static final String DATABASE_CREATE_SCRIPT1 = "Create table INSTRUCTION ( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "description TEXT NOT NULL, "
            + "timer number(4) NOT NULL, "
            + "image TEXT );";

    //создание таблицы Tag #2
    private static final String DATABASE_CREATE_SCRIPT2 = "Create table TAG( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL );";

    //Созадние таблицы Foodcategory #3
    private static final String DATABASE_CREATE_SCRIPT3 = "CREATE table FOODCATEGORY( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL);";

    //Создание таблицы INGREDIENT #4
    private static final String DATABASE_CREATE_SCRIPT4 = "CREATE table INGREDIENT( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL, "
            + "category INTEGER, "
            + "FOREIGN KEY (category) REFERENCES FOODCATEGORY(_id));";

    //Созадние таблицы Dish #5
    private static final String DATABASE_CREATE_SCRIPT5 = "CREATE TABLE DISH( "
            + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL, "
            + "r_simple REAL, "
            + "r_origin REAL, "
            + "r_cashtime REAL, "
            + "date_create TEXT);";

    //Созадние таблицы Dish_INGR #6
    private static final String DATABASE_CREATE_SCRIPT6 = " CREATE TABLE DISH_INGR("
            + "dish INTEGER, "
            + "ingredient INTEGER, "
            + "FOREIGN KEY (dish) REFERENCES DISH(_id), "
            + "FOREIGN KEY (ingredient) REFERENCES INGREDIENT(_id));";

    //Созадние таблицы Dish_INSTR #7
    private static final String DATABASE_CREATE_SCRIPT7 = "CREATE TABLE DISH_INSTR( "
            + "dish INTEGER, " +
            "instruction INTEGER, "
            + "FOREIGN KEY (dish) REFERENCES DISH(_id), "
            + "FOREIGN KEY (instruction) REFERENCES INSTRUCTION(_id));";

    //Созадние таблицы Dish_TAG #8
    //названия столбцов

    private static final String DATABASE_CREATE_SCRIPT8 = "CREATE TABLE DISH_TAG( "
            + "dish INTEGER, "
            + "tag INTEGER,"
            + "FOREIGN KEY (dish) REFERENCES DISH(_id), "
            + "FOREIGN KEY (tag) REFERENCES TAG(_id));";

    //Добавление информации в БД

    //Добавление информации в таблицу INSTRUCTION
    public static final String DATABASE_INSERT_INSTRUCTION_SCRIPT1 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Варить 10 минут', 1, 'egg.jpg'); ";

    public static final String DATABASE_INSERT_INSTRUCTION_SCRIPT2 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Почистить картошку, морковку и лук', 0, 'potato.jpg'); ";
    public static final String DATABASE_INSERT_INSTRUCTION_SCRIPT3 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Порезать кубиками', 0, NULL); ";
    public static final String DATABASE_INSERT_INSTRUCTION_SCRIPT4 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Жарить на медленном огне 15 минут', 1, 'fry.jpg'); ";
    public static final String DATABASE_INSERT_INSTRUCTION_SCRIPT5 = "INSERT INTO INSTRUCTION "
            + "(description, timer, image) "
            + "VALUES ('Выпекать при температуре 180 градусов в течение часа', 1, 'bake.jpg'); ";

    //Добавление информации в таблицу TAG
    public static final String DATABASE_INSERT_TAG_SCRIPT1 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Для студентов');";
    public static final String DATABASE_INSERT_TAG_SCRIPT2 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('На завтрак');";
    public static final String DATABASE_INSERT_TAG_SCRIPT3 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Быстро');";
    public static final String DATABASE_INSERT_TAG_SCRIPT4 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Вегетарианское');";
    public static final String DATABASE_INSERT_TAG_SCRIPT5 = "INSERT INTO TAG "
            + "(name) "
            + "VALUES ('Изи');";

    //Добавление информации в таблицу FOODCATEGORY
    public static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT1 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Овощи');";
    public static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT2 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Фрукты');";
    public static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT3 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Молочные продукты и яйца');";
    public static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT4 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Бакалея');";
    public static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT5 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Мясо');";
    public static final String DATABASE_INSERT_FOODCATEGORY_SCRIPT6 = "INSERT INTO FOODCATEGORY "
            + "(name) "
            + "VALUES ('Рыба');";

    //Добавление информации в таблицу INGREDIENT

    public static final String DATABASE_INSERT_INGREDIENT_SCRIPT1 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Молоко', 3);";
    public static final String DATABASE_INSERT_INGREDIENT_SCRIPT2 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Кефир', 3);";
    public static final String DATABASE_INSERT_INGREDIENT_SCRIPT3 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Форель', 6);";
    public static final String DATABASE_INSERT_INGREDIENT_SCRIPT4 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Говядина', 5);";
    public static final String DATABASE_INSERT_INGREDIENT_SCRIPT5 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Свинина', 5);";
    public static final String DATABASE_INSERT_INGREDIENT_SCRIPT6 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Морковь', 1);";
    public static final String DATABASE_INSERT_INGREDIENT_SCRIPT7 = "INSERT INTO INGREDIENT "
            + "(name, category) "
            + "values ('Картофель', 1);";

    //Добавление информации в таблицу DISH
    public static final String DATABASE_INSERT_DISH_SCRIPT1 = "INSERT INTO DISH "
            + "(name, r_simple, r_origin,r_cashtime,date_create) "
            + "VALUES ('Жаркое',5,3,4.5, ' ');";
    public static final String DATABASE_INSERT_DISH_SCRIPT2 = "INSERT INTO DISH "
            + "(name, r_simple, r_origin,r_cashtime,date_create) "
            + "VALUES ('Рыба со сливочным соусом',3,5,2, ' ');";

    //Добавление информации в таблицу DISH_INGR
    public static final String DATABASE_INSERT_DISH_INGR_SCRIPT1 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (1, 5);";
    public static final String DATABASE_INSERT_DISH_INGR_SCRIPT2 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (1, 6);";
    public static final String DATABASE_INSERT_DISH_INGR_SCRIPT3 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (1, 7);";
    public static final String DATABASE_INSERT_DISH_INGR_SCRIPT4 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (2, 1);";
    public static final String DATABASE_INSERT_DISH_INGR_SCRIPT5 = "INSERT INTO DISH_INGR "
            + "(dish, ingredient) "
            + "VALUES (2, 3);";

    //Добавление информации в таблицу DISH_INSTR
    public static final String DATABASE_INSERT_DISH_INSTR_SCRIPT1 = "INSERT INTO DISH_INSTR "
            + "(dish, instruction) "
            + "VALUES (1,2);";
    public static final String DATABASE_INSERT_DISH_INSTR_SCRIPT2 = "INSERT INTO DISH_INSTR "
            + "(dish, instruction) "
            + "VALUES (1,4);";
    public static final String DATABASE_INSERT_DISH_INSTR_SCRIPT3 = "INSERT INTO DISH_INSTR "
            + "(dish, instruction) "
            + "VALUES (1,1);";

    //Добавление информации в таблицу DISH_TAG
    public static final String DATABASE_INSERT_DISH_TAG_SCRIPT1 = "INSERT INTO DISH_TAG "
            + "(dish, tag) "
            + "VALUES (1,5);";
    public static final String DATABASE_INSERT_DISH_TAG_SCRIPT2 = "INSERT INTO DISH_TAG "
            + "(dish, tag) "
            + "VALUES (1,1);";
    public static final String DATABASE_INSERT_DISH_TAG_SCRIPT3 = "INSERT INTO DISH_TAG "
            + "(dish, tag) "
            + "VALUES (2,5);";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //тут из MainActivity посылается сигнал на создании БД
    //и выполняется скрипт
    @Override
    public void onCreate(SQLiteDatabase db) {
        //создание таблиц
        db.execSQL(DATABASE_CREATE_SCRIPT1);
        db.execSQL(DATABASE_CREATE_SCRIPT2);
        db.execSQL(DATABASE_CREATE_SCRIPT3);
        db.execSQL(DATABASE_CREATE_SCRIPT4);
        db.execSQL(DATABASE_CREATE_SCRIPT5);
        db.execSQL(DATABASE_CREATE_SCRIPT6);
        db.execSQL(DATABASE_CREATE_SCRIPT7);
        db.execSQL(DATABASE_CREATE_SCRIPT8);

        //наполнение таблиц
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT1);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT2);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT3);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT4);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT5);

        db.execSQL(DATABASE_INSERT_TAG_SCRIPT1);
        db.execSQL(DATABASE_INSERT_TAG_SCRIPT2);
        db.execSQL(DATABASE_INSERT_TAG_SCRIPT3);
        db.execSQL(DATABASE_INSERT_TAG_SCRIPT4);
        db.execSQL(DATABASE_INSERT_TAG_SCRIPT5);

        db.execSQL(DATABASE_INSERT_FOODCATEGORY_SCRIPT1);
        db.execSQL(DATABASE_INSERT_FOODCATEGORY_SCRIPT2);
        db.execSQL(DATABASE_INSERT_FOODCATEGORY_SCRIPT3);
        db.execSQL(DATABASE_INSERT_FOODCATEGORY_SCRIPT4);
        db.execSQL(DATABASE_INSERT_FOODCATEGORY_SCRIPT5);
        db.execSQL(DATABASE_INSERT_FOODCATEGORY_SCRIPT6);

        db.execSQL(DATABASE_INSERT_INGREDIENT_SCRIPT1);
        db.execSQL(DATABASE_INSERT_INGREDIENT_SCRIPT2);
        db.execSQL(DATABASE_INSERT_INGREDIENT_SCRIPT3);
        db.execSQL(DATABASE_INSERT_INGREDIENT_SCRIPT4);
        db.execSQL(DATABASE_INSERT_INGREDIENT_SCRIPT5);
        db.execSQL(DATABASE_INSERT_INGREDIENT_SCRIPT6);
        db.execSQL(DATABASE_INSERT_INGREDIENT_SCRIPT7);

        db.execSQL(DATABASE_INSERT_DISH_SCRIPT1);
        db.execSQL(DATABASE_INSERT_DISH_SCRIPT2);

        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT1);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT2);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT3);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT4);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT5);

        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT1);
        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT2);
        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT3);

        db.execSQL(DATABASE_INSERT_DISH_TAG_SCRIPT1);
        db.execSQL(DATABASE_INSERT_DISH_TAG_SCRIPT2);
        db.execSQL(DATABASE_INSERT_DISH_TAG_SCRIPT3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS ");
        // Создаём новую таблицу
        onCreate(db);
    }
}
