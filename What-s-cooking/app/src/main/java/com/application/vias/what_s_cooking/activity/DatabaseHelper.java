package com.application.vias.what_s_cooking.activity;

import android.content.Context;
import android.database.DatabaseErrorHandler;
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
    //версия базы даннх
    private static final int DATABASE_VERSION = 1;
    //созданице таблицы Instruction #1
    //названия столбцов
    public static final String INSTRUCTION_DISCRIPTION_COLUMN = "discription";
    public static final String INSTRUCTION_TIMER_COLUMN = "timer";
    public static final String INSTRUCTION_IMAGE_COLUMN = "image";

    //имя таблицы
    private static final String DATABASE_TABLE1 = "INSTRUCTION";
    private static final String DATABASE_CREATE_SCRIPT1 = "create table "
            + DATABASE_TABLE1 + "( " + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INSTRUCTION_DISCRIPTION_COLUMN
            + " text not null, " + INSTRUCTION_TIMER_COLUMN + " integer, " + INSTRUCTION_IMAGE_COLUMN + " text);";




    //создание таблицы Tag #2
    //названия столбцов
    public static final String TAG_NAME_COLUMN = "name";
    //имя таблицы
    private static final String DATABASE_TABLE2 = "tag";
    private static final String DATABASE_CREATE_SCRIPT2 = "create table "
            + DATABASE_TABLE2 + "( " + BaseColumns._ID
            + " integer primary key autoincrement, " + TAG_NAME_COLUMN
            + " text not null);";



/*
    //Созадние таблицы Foodcategory #3
    //названия столбцов
    public static final String FOODCATEGORY_NAME_COLUMN = "name";
    //имя таблицы
    private static final String DATABASE_TABLE3 = "INSTRUCTION";
    private static final String DATABASE_CREATE_SCRIPT3 = "create table "
            + DATABASE_TABLE3 + "( " + BaseColumns._ID
            + " integer primary key autoincrement, " + FOODCATEGORY_NAME_COLUMN + " TEXT NOT NULL);";




    //Создание таблицы INGREDIENT #4
    //названия столбцов
    public static final String INGREDIENT_NAME_COLUMN = "name";
    public static final String INGREDIENT_CATEGORY_COLUMN = "category";
    public static final String INGREDIENT_FOREIGNKEY_COLUMN = "foreign key";
    //имя таблицы
    private static final String DATABASE_TABLE4 = "INGREDIENT";
    private static final String DATABASE_CREATE_SCRIPT4 = "create table "
            + DATABASE_TABLE4 + "( " + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INGREDIENT_NAME_COLUMN + " TEXT NOT NULL, "
            + INGREDIENT_CATEGORY_COLUMN + " INTEGER, "
            + INGREDIENT_FOREIGNKEY_COLUMN + " (CATEGORY) REFERENCES FOODCATEGORY(_id));";




    //Созадние таблицы Dish #5
    //названия столбцов
    public static final String DISH_NAME_COLUMN = "name";
    public static final String DISH_RSIMPLE_COLUMN = "r_simple";
    public static final String DISH_RORIGIN_COLUMN = "r_origin";
    public static final String DISH_RCASHTIME_COLUMN = "r_cashtime";
    public static final String DISH_DATACREATE_COLUMN = "data_create";
    //имя таблицы
    private static final String DATABASE_TABLE5 = "DISH";
    private static final String DATABASE_CREATE_SCRIPT5 = "create table "
            + DATABASE_TABLE5 + "( " + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DISH_NAME_COLUMN + " TEXT NOT NULL, "
            + DISH_RSIMPLE_COLUMN + " REAL, "
            + DISH_RORIGIN_COLUMN + " REAL, "
            + DISH_RCASHTIME_COLUMN + " REAL,"
            + DISH_DATACREATE_COLUMN + " TEXT);";




    //Созадние таблицы Dish_INGR #6
    //названия столбцов
    public static final String DISHINGR_DISH_COLUMN = "dish";
    public static final String DISHINGR_INSTRUCTION_COLUMN = "ingredient";
    public static final String DISHINGR_FOREIGNKEYDISH_COLUMN = "foreign key";
    public static final String DISHINGR_FOREIGNKEYINSTRUCTION_COLUMN = "foreign key";

    //имя таблицы
    private static final String DATABASE_TABLE6 = "DISH_INGR";
    private static final String DATABASE_CREATE_SCRIPT6 = "create table "
            + DATABASE_TABLE6 + "( " + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DISHINGR_DISH_COLUMN + " INGEGER, " + DISHINGR_INSTRUCTION_COLUMN + " INTEGER, "
            + DISHINGR_FOREIGNKEYDISH_COLUMN + " (dish) REFERENCES DISH(_id), "
            + DISHINGR_FOREIGNKEYINSTRUCTION_COLUMN + " (ingredient) REFERENCES INGREDIENT(_id));";



    //Созадние таблицы Dish_INSTR #7
    //названия столбцов
    public static final String DISHINSTR_DISH_COLUMN = "dish";
    public static final String DISHINSTR_INSTRUCTION_COLUMN = "instruction";
    public static final String DISHINSTR_FOREIGNKEYDISH_COLUMN = "foreign key";
    public static final String DISHINSTR_FOREIGNKEYINSTRUCTION_COLUMN = "foreign key";

    //имя таблицы
    private static final String DATABASE_TABLE7 = "DISH_INSTR";
    private static final String DATABASE_CREATE_SCRIPT7 = "create table "
            + DATABASE_TABLE7 + "( " + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DISHINSTR_DISH_COLUMN + " INGEGER, " + DISHINSTR_INSTRUCTION_COLUMN + " INTEGER, "
            + DISHINSTR_FOREIGNKEYDISH_COLUMN + " (dish) REFERENCES DISH(_id), "
            + DISHINSTR_FOREIGNKEYINSTRUCTION_COLUMN + " (instruction) REFERENCES INGREDIENT(_id));";



    //Созадние таблицы Dish_TAG #8
    //названия столбцов
    public static final String DISHTAG_DISH_COLUMN = "dish";
    public static final String DISHTAG_TAG_COLUMN = "tag";
    public static final String DISHTAG_FOREIGNKEYDISH_COLUMN = "foreign key";
    public static final String DISHTAG_FOREIGNKEYTAG_COLUMN = "foreign key";

    //имя таблицы
    private static final String DATABASE_TABLE8 = "DISH_TAG";
    private static final String DATABASE_CREATE_SCRIPT8 = "create table "
            + DATABASE_TABLE8 + "( " + BaseColumns._ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DISHTAG_DISH_COLUMN + " INGEGER, " + DISHTAG_TAG_COLUMN + " INTEGER, "
            + DISHTAG_FOREIGNKEYDISH_COLUMN + " (dish) REFERENCES DISH(_id), "
            + DISHTAG_FOREIGNKEYTAG_COLUMN + " (instruction) REFERENCES TAG(_id));";



*/


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //тут из MainActivity посылается сигнал на создании БД
    //и выполняется скрипт
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT1);
        db.execSQL(DATABASE_CREATE_SCRIPT2);
  /*    db.execSQL(DATABASE_CREATE_SCRIPT3);
        db.execSQL(DATABASE_CREATE_SCRIPT4);
        db.execSQL(DATABASE_CREATE_SCRIPT5);
        db.execSQL(DATABASE_CREATE_SCRIPT6);
        db.execSQL(DATABASE_CREATE_SCRIPT7);
        db.execSQL(DATABASE_CREATE_SCRIPT8);*/


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE1 + DATABASE_TABLE2);
        // Создаём новую таблицу
        onCreate(db);

    }

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

}
