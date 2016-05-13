package com.application.vias.what_s_cooking.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.entity.Dish;

/**
 * Created by andrey on 11.05.2016.
 */
public class RatingActivity extends AbstractActivity {

    /*
    final static int
        colorAccentR = 0xff,
        colorAccentG = 0x40,
        colorAccentB = 0x81;
    */

    //цветной костыль:

    private final static int
        colorAccentR = 0x00,
        colorAccentG = 0xC8,
        colorAccentB = 0x53;

    private static int
        colorTextR = 0x40,
        colorTextG = 0x40,
        colorTextB = 0x40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rating);
        ApplicationState state = ApplicationState.getInstance();
        Dish dish = state.getDish();
        setTitle(dish.getName());
        //TextView textViewMeal = (TextView) findViewById(R.id.your_meal);
        initSeekBarsListeners();
    }

    public void addRate(View v) {
        //TODO: сохранять оценку пользователем блюда (заносить в базу)

        ApplicationState state = ApplicationState.getInstance();
        state.setDish(null);
        state.setInstructionNumber(-1);
        goToNewActivity(MainActivity.class);
    }

    public void passThroughRate(View v) {
        ApplicationState state = ApplicationState.getInstance();
        state.setDish(null);
        state.setInstructionNumber(-1);
        goToNewActivity(MainActivity.class);
    }

    public void initSeekBarsListeners() {
        SeekBar seekBarTaste = (SeekBar) findViewById(R.id.seekBarTaste);
        seekBarTaste.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            TextView tasteText = (TextView) findViewById(R.id.label_taste);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tasteText.setTextColor(Color.rgb(colorTextR+progress*(colorAccentR-colorTextR)/100,
                        colorTextG+progress*(colorAccentG-colorTextG)/100,
                        colorTextB+progress*(colorAccentB-colorTextB)/100));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar seekBarCost = (SeekBar) findViewById(R.id.seekBarCost);
        seekBarCost.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            TextView costText = (TextView) findViewById(R.id.label_cost);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                costText.setTextColor(Color.rgb(colorTextR+progress*(colorAccentR-colorTextR)/100,
                        colorTextG+progress*(colorAccentG-colorTextG)/100,
                        colorTextB+progress*(colorAccentB-colorTextB)/100));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekBar seekBarDiff = (SeekBar) findViewById(R.id.seekBarDiff);
        seekBarDiff.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            TextView diffText = (TextView) findViewById(R.id.label_difficulty);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                diffText.setTextColor(Color.rgb(colorTextR+progress*(colorAccentR-colorTextR)/100,
                        colorTextG+progress*(colorAccentG-colorTextG)/100,
                        colorTextB+progress*(colorAccentB-colorTextB)/100));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
