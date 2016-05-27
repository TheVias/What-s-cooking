package com.application.vias.what_s_cooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.application.vias.what_s_cooking.entity.Category;
import com.application.vias.what_s_cooking.entity.Dish;
import com.application.vias.what_s_cooking.entity.Ingredient;
import com.application.vias.what_s_cooking.entity.Instruction;
import com.application.vias.what_s_cooking.enums.DBColumn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        db.execSQL(DATABASE_CREATE_SCRIPT9);

        //наполнение таблиц
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT1);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT2);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT3);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT4);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT5);
        db.execSQL(DATABASE_INSERT_INSTRUCTION_SCRIPT6);

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
        db.execSQL(DATABASE_INSERT_DISH_SCRIPT3);

        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT1);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT2);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT3);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT4);
        db.execSQL(DATABASE_INSERT_DISH_INGR_SCRIPT5);

        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT1);
        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT2);
        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT3);
        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT4);
        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT5);
        db.execSQL(DATABASE_INSERT_DISH_INSTR_SCRIPT6);
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

        context.deleteDatabase(DATABASE_NAME);
        // Создаём новую таблицу
        onCreate(db);
    }

    public void addToFavorites(Dish dish) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBColumn.FAVORITE.getColumn(1),dish.get_id());
        db.insert(DBColumn.FAVORITE.getName(),null,values);
        db.close();
    }

    public List<Dish> getFavorites() {
        SQLiteDatabase db = getReadableDatabase();
        List<Dish> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DBColumn.FAVORITE.getName(),null);

        int dish_id;
        if (cursor.moveToFirst()) {
            do {
                dish_id = cursor.getInt(cursor.getColumnIndex(DBColumn.FAVORITE.getColumn(1)));
                Dish dish = getDishById(dish_id);
                list.add(dish);
            } while (cursor.moveToNext());
        } else {
            return null;
        }

        return list;
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

    public Instruction getInstructionById(int i) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.INSTRUCTION.getName(), DBColumn.INSTRUCTION.getColumns(),
                "_id = ?", new String[]{String.valueOf(i)},
                null, null, null);
        int id;
        String desc;
        int timer;
        if (cursor.moveToFirst()) {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.INSTRUCTION.getColumn(0)));
            desc = cursor.getString(cursor.getColumnIndex(DBColumn.INSTRUCTION.getColumn(1)));
            timer = cursor.getInt(cursor.getColumnIndex(DBColumn.INSTRUCTION.getColumn(2)));
        } else {
            return null;
        }
        cursor.close();
        db.close();
        Instruction instruction = new Instruction();
        instruction.set_id(id);
        instruction.setDescription(desc);
        instruction.setTimer(timer);
        return instruction;
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

    public List<Ingredient> getAllIngredients() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.INGREDIENT.getName(), DBColumn.INGREDIENT.getColumns(),
                null, null,
                null, null, null);
        int id,cat;
        String name;
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

    public Dish getDishById(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.DISH.getName(), DBColumn.DISH.getColumns(),
                "_id = ?", new String[]{String.valueOf(id)},
                null, null, null);
        int _id,vote_simple_count,vote_origin_count,vote_cashtime_count,r_simple,r_origin,r_cashtime;
        String name,date_create,description,image;
        Dish dish = new Dish();
        if (cursor.moveToFirst()) {
            _id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(0)));
            name = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(1)));
            vote_simple_count = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(2)));
            vote_origin_count = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(3)));
            vote_cashtime_count = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(4)));
            r_simple = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(5)));
            r_origin = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(6)));
            r_cashtime = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(7)));
            date_create = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(8)));
            description = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(9)));
            image = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(10)));
            dish.set_id(_id);
            dish.setName(name);
            dish.setVote_origin_count(vote_origin_count);
            dish.setVote_cashtime_count(vote_cashtime_count);
            dish.setVote_simple_count(vote_simple_count);
            dish.setR_cashtime(r_cashtime);
            dish.setR_origin(r_origin);
            dish.setR_simple(r_simple);
            dish.setDate_create(date_create);
            //подгрузка пути изображения
            dish.setImage_res(image);
            dish.setDescription(description);
            dish.setInstructions(getInstructionsByDish(dish));
            dish.setIngredients(getIngredientsByDish(dish));
        } else {
            return null;
        }
        cursor.close();
        db.close();
        return dish;
    }

    public List<Dish> getAllDishes() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.DISH.getName(), DBColumn.DISH.getColumns(),
                null, null,
                null, null, null);
        int _id,vote_simple_count,vote_origin_count,vote_cashtime_count,r_simple,r_origin,r_cashtime;
        String name,date_create,description,image;
        List<Dish> list = new ArrayList<Dish>();
        if (cursor.moveToFirst()) {
            do {
                _id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(0)));
                name = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(1)));
                vote_simple_count = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(2)));
                vote_origin_count = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(3)));
                vote_cashtime_count = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(4)));
                r_simple = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(5)));
                r_origin = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(6)));
                r_cashtime = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(7)));
                date_create = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(8)));
                description = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(9)));
                image = cursor.getString(cursor.getColumnIndex(DBColumn.DISH.getColumn(10)));
                Dish dish = new Dish();
                dish.set_id(_id);
                dish.setName(name);
                dish.setVote_origin_count(vote_origin_count);
                dish.setVote_cashtime_count(vote_cashtime_count);
                dish.setVote_simple_count(vote_simple_count);
                dish.setR_cashtime(r_cashtime);
                dish.setR_origin(r_origin);
                dish.setR_simple(r_simple);
                dish.setDate_create(date_create);
                //подгрузка пути изображения
                dish.setImage_res(image);
                dish.setDescription(description);
                dish.setInstructions(getInstructionsByDish(dish));
                dish.setIngredients(getIngredientsByDish(dish));
                list.add(dish);
            } while (cursor.moveToNext());
        } else {
            return null;
        }
        cursor.close();
        db.close();
        return list;
    }

    public List<Ingredient> getIngredientsByDish(Dish dish) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.DISH_INGR.getName(), DBColumn.DISH_INGR.getColumns(),
                "dish = ?", new String[]{String.valueOf(dish.get_id())},
                null, null, null) ;
        int ingr_id;
        List<Ingredient> list = new ArrayList<Ingredient>();
        if (cursor.moveToFirst()) {
            do {
                ingr_id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INGR.getColumn(2)));
                list.add(getIngredientById(ingr_id));
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

    public List<Instruction> getInstructionsByDish(Dish dish) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBColumn.DISH_INSTR.getName(), DBColumn.DISH_INSTR.getColumns(),
                "dish = ?", new String[]{String.valueOf(dish.get_id())},
                null, null, null) ;
        int id;
        int dish_id;
        int instr_id;
        int instr_num;
        List<Instruction> list = new ArrayList<Instruction>();
        if (cursor.moveToFirst()) {
            do {
                dish_id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INSTR.getColumn(1)));
                instr_id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INSTR.getColumn(2)));
                instr_num = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INSTR.getColumn(3))) + 1;
                Instruction instruction = getInstructionById(instr_id);
                instruction.setInstruction_num(instr_num);
                list.add(instruction);
            } while (cursor.moveToNext());
        } else {
            return null;
        }
        cursor.close();
        db.close();
        return list;
    }

    public List<Dish> getDishesByIngredients(List<Ingredient> ingredients){
        SQLiteDatabase db = getReadableDatabase();
        List<Dish> list = getAllDishes();
        List<Dish> final_list = new ArrayList<Dish>();

        for (Dish dish : list) {
            if (ingredients != null && dish.getIngredients() != null) {
                if (ingredients.containsAll(dish.getIngredients())) {
                    final_list.add(dish);
                }
            } else {
                final_list.add(dish);
            }
        }

        return final_list;
    }

    public DBSnapshot getDBSnapshot () {
        DBSnapshot snapshot = new DBSnapshot();
        SQLiteDatabase db = getReadableDatabase();
        Set<Integer> set;
        int id;

        //скан ингредиентов
        Cursor cursor = db.query(DBColumn.INGREDIENT.getName(), DBColumn.INGREDIENT.getColumns(),
                null, null,
                null, null, null) ;
        cursor.moveToFirst();
        set = new HashSet<Integer>();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.INGREDIENT.getColumn(0)));
            set.add(Integer.valueOf(id));
        } while (cursor.moveToNext());
        snapshot.setIngredient(set);

        //скан категорий
        cursor = db.query(DBColumn.CATEGORY.getName(), DBColumn.CATEGORY.getColumns(),
                null, null,
                null, null, null) ;
        set = new HashSet<Integer>();
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.CATEGORY.getColumn(0)));
            set.add(Integer.valueOf(id));
        } while (cursor.moveToNext());
        snapshot.setCategory(set);

        //скан блюд
        cursor = db.query(DBColumn.DISH.getName(), DBColumn.DISH.getColumns(),
                null, null,
                null, null, null) ;
        set = new HashSet<Integer>();
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH.getColumn(0)));
            set.add(Integer.valueOf(id));
        } while (cursor.moveToNext());
        snapshot.setDish(set);

        //скан инструкций
        cursor = db.query(DBColumn.INSTRUCTION.getName(), DBColumn.INSTRUCTION.getColumns(),
                null, null,
                null, null, null) ;
        set = new HashSet<Integer>();
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.INSTRUCTION.getColumn(0)));
            set.add(Integer.valueOf(id));
        } while (cursor.moveToNext());
        snapshot.setInstruction(set);

        //скан связки1
        cursor = db.query(DBColumn.DISH_INGR.getName(), DBColumn.DISH_INGR.getColumns(),
                null, null,
                null, null, null) ;
        set = new HashSet<Integer>();
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INGR.getColumn(0)));
            set.add(Integer.valueOf(id));
        } while (cursor.moveToNext());
        snapshot.setDish_ingr(set);

        //скан связки2
        cursor = db.query(DBColumn.DISH_INSTR.getName(), DBColumn.DISH_INSTR.getColumns(),
                null, null,
                null, null, null) ;
        set = new HashSet<Integer>();
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_INSTR.getColumn(0)));
            set.add(Integer.valueOf(id));
        } while (cursor.moveToNext());
        snapshot.setDish_instr(set);

        //скан связки3
        cursor = db.query(DBColumn.DISH_TAG.getName(), DBColumn.DISH_TAG.getColumns(),
                null, null,
                null, null, null) ;
        set = new HashSet<Integer>();
        cursor.moveToFirst();
        do {
            id = cursor.getInt(cursor.getColumnIndex(DBColumn.DISH_TAG.getColumn(0)));
            set.add(Integer.valueOf(id));
        } while (cursor.moveToNext());
        snapshot.setDish_tag(set);

        cursor.close();
        db.close();
        return snapshot;
    }
}
