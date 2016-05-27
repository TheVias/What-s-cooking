package com.application.vias.what_s_cooking.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.DatabaseHelper;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.RecipeAdapter;
import com.application.vias.what_s_cooking.entity.Dish;
import java.util.ArrayList;
import java.util.List;

public class RecipeRVActivity extends AbstractActivity {

    public List<Dish> recipe;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_rv_activity);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        recipe = new ArrayList<>();
        ApplicationState state = ApplicationState.getInstance();
        DatabaseHelper helper = state.getHelper();
        List<Dish> dishList = null;

        String action = (String)getIntent().getExtras().get("action");
        if (action.equals("show_all")) {
            setTitle("Все наши рецепты");
            dishList = helper.getAllDishes();
        }
        if (action.equals("show_for_ingredients")) {
            setTitle("Рецепты для вас");
            dishList = helper.getDishesByIngredients(state.getIngredientList());
        }
        if (action.equals("show_favorite")) {
            setTitle("Ваши любимые блюда");
            dishList = helper.getFavorites();
        }

        recipe.addAll(dishList);

    }

    public void initializeAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recipe_rv);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecipeAdapter adapter = new RecipeAdapter(recipe,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

}
