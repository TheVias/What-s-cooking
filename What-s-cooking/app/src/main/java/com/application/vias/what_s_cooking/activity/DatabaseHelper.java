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
public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns{

    //созданице таблицы Instruction
    //названия столбцов
    public static final String DISCRIPTION_COLUMN = "discription";
    public static final String TIMER_COLUMN = "timer";

    //имя базы данных
    private static final String DATABASE_NAME = "database.db";

    //версия базы даннх
    private static final int DATABASE_VERSION = 1;

    //имя таблицы
    private static final String DATABASE_TABLE1 = "instruction";
    private static final String DATABASE_CREATE_SCRIPT1 = "create table "
            + DATABASE_TABLE1 + "( " + BaseColumns._ID
            + " integer primary key autoincrement, " + DISCRIPTION_COLUMN
            + " text not null, " + TIMER_COLUMN + " integer);";



    //создание таблицы Tag
    //названия столбцов
    public static final String NAME_COLUMN = "name";
    public static final String LINK_COLUMN = "link";


    //имя таблицы
    private static final String DATABASE_TABLE2 = "tag";
    private static final String DATABASE_CREATE_SCRIPT2 = "create table "
            + DATABASE_TABLE2 + "( " + BaseColumns._ID
            + " integer primary key autoincrement, " + NAME_COLUMN
            + " text not null, " + LINK_COLUMN + " integer);";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    //тут из MainActivity посылается сигнал на создании БД
    //и выполняется скрипт
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT1);
        db.execSQL(DATABASE_CREATE_SCRIPT2);
        db.execSQL("INSERT 1 INTO TABLE");

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
