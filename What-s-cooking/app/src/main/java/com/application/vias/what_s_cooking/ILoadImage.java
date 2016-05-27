package com.application.vias.what_s_cooking;

import android.content.Context;
import android.graphics.Bitmap;

import com.application.vias.what_s_cooking.entity.CookingImage;

/**
 * Created by Svetlana on 22.05.2016.
 */
public interface ILoadImage {

    Bitmap load(String name, Context context, int reqWidth, int reqHeight);
}
