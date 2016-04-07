package com.application.vias.what_s_cooking.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


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

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //тут из MainActivity посылается сигнал на создании БД
    //и выполняется скрипт
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT1);
        db.execSQL(DATABASE_CREATE_SCRIPT2);
        db.execSQL(DATABASE_CREATE_SCRIPT3);
        db.execSQL(DATABASE_CREATE_SCRIPT4);
        db.execSQL(DATABASE_CREATE_SCRIPT5);
        db.execSQL(DATABASE_CREATE_SCRIPT6);
        db.execSQL(DATABASE_CREATE_SCRIPT7);
        db.execSQL(DATABASE_CREATE_SCRIPT8);
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
