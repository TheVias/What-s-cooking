package com.application.vias.what_s_cooking;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.application.vias.what_s_cooking.adapter.RecipeAdapter;
import com.application.vias.what_s_cooking.entity.CookingImage;
import com.application.vias.what_s_cooking.entity.Dish;

import java.util.List;

/**
 * Created by andrey on 27.05.2016.
 */
public class AsyncLoader extends AsyncTask<Void,Void,Void> {
    Context context;
    Dish dish;
    ImageView imageView;
    RecipeAdapter adapter;
    CookingImage cookingImage;
    int viewHeight;
    int viewWidth;
    /*
    RecyclerView recyclerView;
    RecipeAdapter adapter;
    */

    public AsyncLoader(Context context, RecipeAdapter adapter, Dish dish, ImageView imageView, int viewWidth, int viewHeight) {
        this.context = context;
        this.dish = dish;
        this.imageView = imageView;
        this.adapter = adapter;
        this.viewHeight = viewHeight;
        this.viewWidth = viewWidth;
    }

    /*
    public AsyncLoader(Context context, RecyclerView recyclerView, RecipeAdapter adapter) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.adapter = adapter;
    }
    */

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Bitmap bitmap = cookingImage.getImage();
        bitmap = Bitmap.createScaledBitmap(bitmap, imageView.getWidth(), imageView.getHeight(), true);
        dish.setImage(cookingImage);
        imageView.setImageBitmap(bitmap);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Void... params) {
        ILoadImage loader = new LocalLoad();
        cookingImage = loader.load(dish.getImage_res(), context, viewWidth, viewHeight);
        /*
        List<Dish> list = adapter.getRecipes();
        for (int i = 0; i < adapter.getItemCount(); i++) {
            recyclerView.getChildAt(i);
        }
        */
        return null;
    }
}
