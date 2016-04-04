package com.application.vias.what_s_cooking.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.Category;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-активити с выбором категории ингредиента
 */
public class AllCategoriesActivity extends AbstractActivity{

    private ListView listCategoriesView;
    private List<Category> listCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Выбери категорию");
        setContentView(R.layout.activity_all_categories);

        initListCategories();

        listCategoriesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listCategories.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Инициализация списка категорий
     */
    private void initListCategories() {
        listCategoriesView = (ListView) findViewById(R.id.listCategories);
        listCategories = new ArrayList<Category>();
        listCategories.add(new Category(1,"Овощи"));
        listCategories.add(new Category(2,"Мясо"));
        listCategories.add(new Category(3,"Фрукты"));
        listCategories.add(new Category(4,"Прочее"));
        CategoryAdapter adapter = new CategoryAdapter(this,listCategories);
        listCategoriesView.setAdapter(adapter);
    }
}
