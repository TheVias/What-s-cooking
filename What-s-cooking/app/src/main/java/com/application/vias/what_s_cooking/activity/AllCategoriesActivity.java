package com.application.vias.what_s_cooking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Pair;
import android.view.View;
import android.widget.ExpandableListView;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.DatabaseHelper;
import com.application.vias.what_s_cooking.entity.Category;
import com.application.vias.what_s_cooking.entity.Ingredient;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.IngredientsInCategoriesAdapter;

import java.util.ArrayList;
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
        setTitle(R.string.all_categories_activity_title);
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
                    Snackbar.make(v, ingredient.getName()+" добавлен", Snackbar.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_confirm_categories);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RecipeRVActivity.class);
                intent.putExtra("action","show_for_ingredients");
                startActivity(intent);
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
