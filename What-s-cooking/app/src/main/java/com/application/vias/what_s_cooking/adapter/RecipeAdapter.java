package com.application.vias.what_s_cooking.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.AsyncLoader;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.activity.CookingActivity;
import com.application.vias.what_s_cooking.entity.Dish;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.recipeViewHolder> {

    public static class recipeViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView recipeName;
        TextView recipeText;
        ImageView recipePhoto;
        ListView recipeTag;
        RelativeLayout container;

        recipeViewHolder(View itemView) {
            super(itemView);
            container = (RelativeLayout)itemView.findViewById(R.id.recipe_container);
            cv = (CardView)itemView.findViewById(R.id.cv);
            recipeName = (TextView)itemView.findViewById(R.id.recipe_name);
            recipeText = (TextView)itemView.findViewById(R.id.recipe_text);
            recipePhoto = (ImageView)itemView.findViewById(R.id.recipe_photo);
        }
    }

    private List<Dish> recipes;
    private Context context;

    public RecipeAdapter(List<Dish> recipes){
        this.recipes = recipes;
    }

    public RecipeAdapter(List<Dish> recipes, Context context) {
        this.recipes = recipes;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public recipeViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_item, viewGroup, false);
        recipeViewHolder pvh = new recipeViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(recipeViewHolder recipeViewHolder, int i) {
        final Dish recipe = recipes.get(i);
        recipe.setContext(context);
        recipeViewHolder.recipeName.setText(recipe.getName());
        recipeViewHolder.recipeText.setText(recipe.getDescription());
        ImageView imageView = recipeViewHolder.recipePhoto;
        if (recipe.getImage() == null) {
            imageView.setImageDrawable(null);
            AsyncLoader loader = new AsyncLoader(context,this,recipe,imageView,imageView.getWidth(),imageView.getHeight());
            loader.execute();
        } else {
            imageView.setImageBitmap(recipe.getImage().getImage());
        }
        //recipeViewHolder.recipePhoto.setImageBitmap(recipe.getImage().getImage());
        recipeViewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationState.getInstance().setDish(recipe);
                ApplicationState.getInstance().setInstructionNumber(0);
                //Toast.makeText(context,recipe.getInstructions().get(0).getDescription(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,CookingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        //recipeViewHolder.recipeTag
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public List<Dish> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Dish> recipes) {
        this.recipes = recipes;
    }
}