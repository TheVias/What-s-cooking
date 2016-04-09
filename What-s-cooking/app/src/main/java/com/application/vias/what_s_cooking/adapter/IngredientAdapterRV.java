package com.application.vias.what_s_cooking.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.Ingredient;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.activity.DatabaseHelper;

import java.util.List;

/**
 * Created by andrey on 09.04.2016.
 */
public class IngredientAdapterRV extends RecyclerView.Adapter<IngredientAdapterRV.IngredientViewHolder> {

    List<Ingredient> ingredients;

    public static class IngredientViewHolder extends RecyclerView.ViewHolder {
        TextView ingredientName;
        TextView ingredientCategory;
        IngredientViewHolder(View itemView) {
            super(itemView);
            ingredientName = (TextView)itemView.findViewById(R.id.ingredient_name);
            ingredientCategory = (TextView)itemView.findViewById(R.id.ingredient_description);
        }
    }

    public IngredientAdapterRV(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredient_layout, parent, false);
        IngredientViewHolder pvh = new IngredientViewHolder(view);
        return pvh;
    }

    @Override
    public void onBindViewHolder(IngredientViewHolder holder, int position) {
        Ingredient ingredient = ingredients.get(position);
        holder.ingredientName.setText(ingredient.getName());
        ApplicationState state = ApplicationState.getInstance();
        DatabaseHelper helper = state.getHelper();
        holder.ingredientCategory.setText(helper.getCategoryById(ingredient.getCategory()).getName());
    }
}
