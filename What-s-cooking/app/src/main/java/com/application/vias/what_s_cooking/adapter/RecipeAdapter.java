package com.application.vias.what_s_cooking.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.entity.Dish;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.recipeViewHolder> {

    public static class recipeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView recipeName;
        TextView recipeText;
        ImageView recipePhoto;
        ListView recipeTag;

        recipeViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            recipeName = (TextView)itemView.findViewById(R.id.recipe_name);
            recipeText = (TextView)itemView.findViewById(R.id.recipe_text);
            recipePhoto = (ImageView)itemView.findViewById(R.id.recipe_photo);


    }
}

    List<Dish> recipes;

    public RecipeAdapter(List<Dish> recipes){
        this.recipes = recipes;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public recipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_item, viewGroup, false);
        recipeViewHolder pvh = new recipeViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(recipeViewHolder recipeViewHolder, int i) {
        final Dish recipe = recipes.get(i);
        recipeViewHolder.recipeName.setText(recipe.getName());
        recipeViewHolder.recipeText.setText(recipe.getDescription());
        //recipeViewHolder.recipeTag

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }


}


