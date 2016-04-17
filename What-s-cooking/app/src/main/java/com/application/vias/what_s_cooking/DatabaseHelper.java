package com.application.vias.what_s_cooking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.application.vias.what_s_cooking.entity.Category;
import com.application.vias.what_s_cooking.entity.Ingredient;
import com.application.vias.what_s_cooking.enums.DBColumn;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс для создания локальной БД. Тут создаются все таблицы и связи.
 */


/**
 * Created by wesked on 04.04.16.
 */
public class DatabaseHelper extends AbstractDatabaseHelper implements BaseColumns {

    private Context context;

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    //Создание таблиц и стандартные инсерты
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
//
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

    public Ingredient getIngredientById(int i) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.INGREDIENT.getName(), DBColumn.INGREDIENT.getColumns(),
                "_id = ?", new String[]{String.valueOf(i)},
                null, null, null);
        int id;
        String name;
        int cat;
        if (cursor.moveToFirst()) {

            id = cursor.getInt(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(0)));
            name = cursor.getString(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(1)));
            cat = cursor.getInt(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(2)));

        } else {
            return null;
        }
        cursor.close();
        db.close();
        return new Ingredient(id,name,cat);
    }

    public Category getCategoryById(int i) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.CATEGORY.getName(), DBColumn.CATEGORY.getColumns(),
                "_id = ?", new String[]{String.valueOf(i)},
                null, null, null);
        int id;
        String name;
        if (cursor.moveToFirst()) {

            id = cursor.getInt(cursor.getColumnIndex(DBColumn.CATEGORY.getColumn(0)));
            name = cursor.getString(cursor.getColumnIndex(DBColumn.CATEGORY.getColumn(1)));

        } else {
            return null;
        }
        cursor.close();
        db.close();
        return new Category(id,name);
    }

    public List<Category> getAllCategories() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.CATEGORY.getName(), DBColumn.CATEGORY.getColumns(),
                null, null,
                null, null, null);
        int id;
        String name;
        List<Category> list = new ArrayList<Category>();
        if (cursor.moveToFirst()) {

            do {
                id = cursor.getInt(cursor.getColumnIndex(DBColumn.CATEGORY.getColumn(0)));
                name = cursor.getString(cursor.getColumnIndex(DBColumn.CATEGORY.getColumn(1)));
                list.add(new Category(id, name));
            } while (cursor.moveToNext());
        } else {
            return null;
        }
        cursor.close();
        db.close();
        return list;
    }

    public List<Ingredient> getIngredientsByCategory(Category category) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.INGREDIENT.getName(), DBColumn.INGREDIENT.getColumns(),
                "category = ?", new String[]{String.valueOf(category.get_id())},
                null, null, null) ;
        int id;
        String name;
        int cat;
        List<Ingredient> list = new ArrayList<Ingredient>();
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(0)));
                name = cursor.getString(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(1)));
                cat = cursor.getInt(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(2)));
                list.add(new Ingredient(id, name, cat));
            } while (cursor.moveToNext());
        } else {
            return null;
        }
        cursor.close();
        db.close();
        return list;
    }

    public DBSnapshot getDBSnapshot () {
        DBSnapshot snapshot = new DBSnapshot();
        SQLiteDatabase db = getReadableDatabase();
        int id,size;
        int[] mas;

        //скан ингредиентов
        Cursor cursor = db.query(DBColumn.INGREDIENT.getName(), DBColumn.INGREDIENT.getColumns(),
                null, null,
                null, null, null) ;
        size = cursor.getCount();
        mas = new int[size];
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(0)));
            mas[cursor.getPosition()]=id;
        } while (cursor.moveToNext());
        snapshot.setIngredient(mas);

        //скан категорий
        cursor = db.query(DBColumn.CATEGORY.getName(), DBColumn.CATEGORY.getColumns(),
                null, null,
                null, null, null) ;
        size = cursor.getCount();
        mas = new int[size];
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.CATEGORY.getColumn(0)));
            mas[cursor.getPosition()]=id;
        } while (cursor.moveToNext());
        snapshot.setCategory(mas);

        //скан блюд
        cursor = db.query(DBColumn.DISH.getName(), DBColumn.DISH.getColumns(),
                null, null,
                null, null, null) ;
        size = cursor.getCount();
        mas = new int[size];
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(0)));
            mas[cursor.getPosition()]=id;
        } while (cursor.moveToNext());
        snapshot.setDish(mas);

        //скан инструкций
        cursor = db.query(DBColumn.INSTRUCTION.getName(), DBColumn.INSTRUCTION.getColumns(),
                null, null,
                null, null, null) ;
        size = cursor.getCount();
        mas = new int[size];
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.INSTRUCTION.getColumn(0)));
            mas[cursor.getPosition()]=id;
        } while (cursor.moveToNext());
        snapshot.setInstruction(mas);

        //скан связки1
        cursor = db.query(DBColumn.DISH_INGR.getName(), DBColumn.DISH_INGR.getColumns(),
                null, null,
                null, null, null) ;
        size = cursor.getCount();
        mas = new int[size];
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INGR.getColumn(0)));
            mas[cursor.getPosition()]=id;
        } while (cursor.moveToNext());
        snapshot.setDish_ingr(mas);

        //скан связки2
        cursor = db.query(DBColumn.DISH_INSTR.getName(), DBColumn.DISH_INSTR.getColumns(),
                null, null,
                null, null, null) ;
        size = cursor.getCount();
        mas = new int[size];
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INSTR.getColumn(0)));
            mas[cursor.getPosition()]=id;
        } while (cursor.moveToNext());
        snapshot.setDish_instr(mas);

        //скан связки3
        cursor = db.query(DBColumn.DISH_TAG.getName(), DBColumn.DISH_TAG.getColumns(),
                null, null,
                null, null, null) ;
        size = cursor.getCount();
        mas = new int[size];
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_TAG.getColumn(0)));
            mas[cursor.getPosition()]=id;
        } while (cursor.moveToNext());
        snapshot.setDish_tag(mas);

        cursor.close();
        db.close();
        return snapshot;
    }
}
