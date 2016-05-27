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
    public CookingImage load(String name, Context context, int reqWidth, int reqHeight) {
        CookingImage cImage = new CookingImage();
        int resID = context.getResources().getIdentifier(name , "drawable", context.getPackageName());
        Bitmap bitmap;
        if(resID!=0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), resID, options);

            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;

            if (height > reqHeight || width > reqWidth) {

                final int halfHeight = height / 2;
                final int halfWidth = width / 2;

                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while ((halfHeight / inSampleSize) > reqHeight
                        && (halfWidth / inSampleSize) > reqWidth) {
                    inSampleSize *= 2;
                }
            }

            options.inSampleSize = inSampleSize;
            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(context.getResources(), resID, options);
            /*
            bitmap = BitmapFactory.decodeResource(context.getResources(), resID, options);
            */
        } else{
            BitmapFactory.Options options = new BitmapFactory.Options();
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.fishcream);
        }
        cImage.setImage(bitmap);
        cImage.setName(name);
        return cImage;
    }
}
