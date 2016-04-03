package com.application.vias.what_s_cooking.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

public class LinkActivity extends AbstractActivity {

    private ListView listView;
    private List<Ingredient> listIngredient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);

        initToolbar();
        initIgredientsList();

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listIngredient.remove(position);
                //refreshIngredientsList();
                Toast.makeText(getApplicationContext(), listIngredient.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        */
    }

    @Override
    void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.option1);
        toolbar.inflateMenu(R.menu.menu_link_activity);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.item_complete) {
                    Toast.makeText(getApplicationContext(), "Complete!", Toast.LENGTH_SHORT).show();
                    listIngredient.add(new Ingredient(listIngredient.size() + 1, "Морковка", "Овощи"));
                    refreshIngredientsList();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    private void initIgredientsList() {
        listView = (ListView) findViewById(R.id.listIngredients);
        listIngredient = new ArrayList<Ingredient>();
        /*
        listIngredient.add(new Ingredient(1,"Носки","Потные, мужские"));
        listIngredient.add(new Ingredient(2,"Морковка","Красная, российская"));
        listIngredient.add(new Ingredient(3,"Трусы","Потные, мужские"));
        listIngredient.add(new Ingredient(4,"Мука","Белая, обычная"));
        */
        listIngredient.add(new Ingredient(4,"Мука","Выпечка"));
        IngredientAdapter adapter = new IngredientAdapter(this,listIngredient);
        listView.setAdapter(adapter);
    }

    public void refreshIngredientsList() {
        IngredientAdapter adapter = new IngredientAdapter(this,listIngredient);
        listView.setAdapter(adapter);
    }

}
