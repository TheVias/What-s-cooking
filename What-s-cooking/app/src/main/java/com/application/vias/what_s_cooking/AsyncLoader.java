package com.application.vias.what_s_cooking;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.application.vias.what_s_cooking.adapter.RecipeAdapter;
import com.application.vias.what_s_cooking.entity.CookingImage;
import com.application.vias.what_s_cooking.entity.Dish;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by andrey on 27.05.2016.
 */
public class AsyncLoader extends AsyncTask<Void,Void,Bitmap> {

    private Context context;
    private Dish dish;
    private ImageView imageView;
    private RecipeAdapter adapter;
    private int viewHeight;
    private int viewWidth;
    private WeakReference<ImageView> imageViewReference;
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
        imageViewReference = new WeakReference<ImageView>(imageView);
    }

    /*
    public AsyncLoader(Context context, RecyclerView recyclerView, RecipeAdapter adapter) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.adapter = adapter;
    }
    */

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
        /*
        imageView.setImageBitmap(bitmap);
        */
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        ILoadImage loader = new LocalLoad();
        Bitmap bitmap = loader.load(dish.getImage_res(), context, viewWidth, viewHeight);
        return bitmap;
    }
}
