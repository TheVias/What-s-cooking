package com.application.vias.what_s_cooking.activity;

import android.media.AsyncPlayer;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.Category;
import com.application.vias.what_s_cooking.Ingredient;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.CategoryAdapter;
import com.application.vias.what_s_cooking.adapter.IngredientsInCategoriesAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Класс-активити с выбором категории ингредиента
 */
public class AllCategoriesActivity extends AbstractActivity{

    private ExpandableListView listCategoriesAndIngredientsView;
    //жуткий элемент для вывода двухуровнего списка
    private List<Pair<Category,List<Ingredient>>> listCategoriesAndIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Выбери категорию");
        setContentView(R.layout.activity_all_categories);

        initListCategories();


        listCategoriesAndIngredientsView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Ingredient ingredient = listCategoriesAndIngredients.get(groupPosition).second.get(childPosition);
                ApplicationState state = ApplicationState.getInstance();
                if (state.getIngredientList().contains(ingredient)) {
                    //ignore
                } else {
                    state.getIngredientList().add(ingredient);
                    Toast.makeText(getApplicationContext(),"Added!",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    /**
     * Инициализация списка категорий с подразделами в виде ингредиентов
     */
    private void initListCategories() {
        listCategoriesAndIngredientsView = (ExpandableListView) findViewById(R.id.listCategories);
        ApplicationState state = ApplicationState.getInstance();
        DatabaseHelper helper = state.getHelper();
        List<Category> listCategories = helper.getAllCategories();
        listCategoriesAndIngredients = new ArrayList<Pair<Category,List<Ingredient>>>();
        for (Category category : listCategories) {
            List<Ingredient> list = helper.getIngredientsByCategory(category);
            Pair<Category,List<Ingredient>> pair;
            if (list!=null) {
                pair = new Pair<Category,List<Ingredient>>(category,list);
            } else {
                pair = new Pair<Category,List<Ingredient>>(category,new ArrayList<Ingredient>());
            }
            listCategoriesAndIngredients.add(pair);
        }
        IngredientsInCategoriesAdapter adapter = new IngredientsInCategoriesAdapter(this,listCategoriesAndIngredients);
        listCategoriesAndIngredientsView.setAdapter(adapter);
    }
}
