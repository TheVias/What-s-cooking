package com.application.vias.what_s_cooking;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.application.vias.what_s_cooking.entity.CookingImage;


/**
 * Created by Svetlana on 22.05.2016.
 */
public class LocalLoad implements ILoadImage {

    @Override
    public CookingImage load(String name, Context context) {
        CookingImage cImage = new CookingImage();
        int resID = context.getResources().getIdentifier(name , "drawable", context.getPackageName());
        Bitmap bitmap;
        if(resID!=0) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), resID);
        } else{
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.fishcream);
        }
        cImage.setImage(bitmap);
        cImage.setName(name);
        return cImage;
    }
}
