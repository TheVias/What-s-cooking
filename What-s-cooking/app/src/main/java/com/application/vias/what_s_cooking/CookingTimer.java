package com.application.vias.what_s_cooking;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Chronometer;
import android.widget.Toast;

import com.application.vias.what_s_cooking.view.TimerView;

import java.io.Serializable;

/**
 * Created by Svetlana on 09.04.2016.
 */
public class CookingTimer {

    private Chronometer chronometer;
    private TimerView timerView;
    private Context context;
    private int duration;

    public CookingTimer() {
    }

    public void initTimer (Context context, Chronometer chronometer, TimerView timerView) {
        this.chronometer = chronometer;
        this.timerView = timerView;
        this.context = context;
        duration = 0;
        chronometer.setVisibility(View.INVISIBLE);
        timerView.setVisibility(View.INVISIBLE);
    }

    public void startTimer(int time) {
        if (time != 0) {
            // КОНВЕРТИМ ВРЕМЯ В НУЖНЫЙ ФОРМАТ (НА ДАННЫЙ МОМЕНТ ВХОДЯЩЕЕ ЧИСЛО - ЧИСЛО МИНУТ)
            // ПОЭТОМУ ПРЕОБРАЗУЕМ ЕГО В КОЛИЧЕСТВО МИЛИСЕКУНД
            final int newTime = time*60*1000;

            final Animation timerAnimFadeIn = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            final Animation timerAnimFadeOut = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
            final Animation chronoAnimFadeIn = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
            final Animation chronoAnimFadeOut = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
            chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    if (SystemClock.elapsedRealtime() - chronometer.getBase() > newTime) {
                        Toast.makeText(context, "готово", Toast.LENGTH_SHORT).show();
                        chronometer.stop();
                        timerView.startAnimation(timerAnimFadeOut);
                    }
                }
            });
            timerAnimFadeIn.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    timerView.setVisibility(View.VISIBLE);
                    chronometer.setVisibility(View.VISIBLE);
                    chronometer.startAnimation(chronoAnimFadeIn);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            timerAnimFadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    chronometer.startAnimation(chronoAnimFadeOut);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    timerView.setVisibility(View.INVISIBLE);
                    chronometer.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            timerAnimFadeIn.setInterpolator(new AccelerateInterpolator());
            timerAnimFadeIn.setDuration(1000);
            timerAnimFadeOut.setInterpolator(new AccelerateInterpolator());
            timerAnimFadeOut.setDuration(1000);
            chronoAnimFadeIn.setInterpolator(new AccelerateInterpolator());
            chronoAnimFadeIn.setDuration(1000);
            chronoAnimFadeOut.setInterpolator(new AccelerateInterpolator());
            chronoAnimFadeOut.setDuration(1000);
            timerView.startAnimation(timerAnimFadeIn);
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void start() {
        startTimer(duration);
    }
}
