package com.application.vias.what_s_cooking.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.Ingredient;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.IngredientAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Активити со списком ингредиентов, из которых следует приготовить блюдо. Можно добавлять ингредиенты,
 * удалять их или отправиться к выбору блюда по существующему списку ингредиентов.
 */
public class LinkActivity extends AbstractActivity {

    private ListView listIngredientView;
    private List<Ingredient> listIngredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.AppDefault);
        //устанавливаем заголовок тулбара
        setTitle(R.string.option1);
        setContentView(R.layout.activity_link);

        initIgredientsList();
        listIngredientView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), listIngredient.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FloatingActionButton) findViewById(R.id.fab)).hide();
                goToNewActivity(AllCategoriesActivity.class);
            }
        });

    }

    //Методы вызывается при инициализации пунктов меню. Меню представляет собой R.menu.menu_link_activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_link_activity, menu);
        /*
        MenuItem locationItem = menu.add(0, R.id.menu_location, 0, R.string.menu_location);
        locationItem.setIcon(R.drawable.ic_action_location);
        MenuItemCompat.setShowAsAction(locationItem, MenuItem.SHOW_AS_ACTION_IF_ROOM);
        */
        return true;
    }

    //Метод вызывается при клике на элемент меню, по айдишнику элемента определяем куда кликнули и обрабатываем соответственно
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_complete:
                Toast.makeText(getApplicationContext(), "Набор составлен!", Toast.LENGTH_SHORT).show();
                //listIngredient.add(new Ingredient(listIngredient.size() + 1, "Морковка", "Овощи"));
                //refreshIngredientsList();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Метод инициализирует список ингридиентов
     */
    private void initIgredientsList() {
        listIngredientView = (ListView) findViewById(R.id.listIngredients);
        listIngredient = new ArrayList<Ingredient>();
        IngredientAdapter adapter = new IngredientAdapter(this,listIngredient);
        listIngredientView.setAdapter(adapter);
    }

    /**
     * Метод обновляет адаптер списка ингридиентов
     */
    public void refreshIngredientsList() {
        IngredientAdapter adapter = new IngredientAdapter(this,listIngredient);
        listIngredientView.setAdapter(adapter);
    }

}
