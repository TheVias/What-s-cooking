package com.application.vias.what_s_cooking.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.entity.Dish;

/**
 * Created by andrey on 11.05.2016.
 */
public class RatingActivity extends AbstractActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        ApplicationState state = ApplicationState.getInstance();
        Dish dish = state.getDish();
        setTitle(dish.getName());
        TextView textViewMeal = (TextView) findViewById(R.id.your_meal);
        textViewMeal.setText(getString(R.string.your_meal)+" "+dish.getName()+" "+getString(R.string.in_time)+" "+state.getCookingTime()+" "+getString(R.string.minutes));
    }
}
