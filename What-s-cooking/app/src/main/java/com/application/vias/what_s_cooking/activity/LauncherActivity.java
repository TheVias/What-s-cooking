package com.application.vias.what_s_cooking.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.entity.Ingredient;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.SocketManager;

import java.util.List;

/**
 * Лаунчер активити (В ДАННЫЙ МОМЕНТ ЗАГЛУШКА)
 */
public class LauncherActivity extends Activity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case 0: {
                        //Snackbar.make(findViewById(android.R.id.content),"GOOD",Snackbar.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "GOOD", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 1: {
                        //Snackbar.make(findViewById(android.R.id.content), "BAD", Snackbar.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "BAD", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case 2: {
                        Snackbar.make(findViewById(android.R.id.content),"Соединение установлено",Snackbar.LENGTH_SHORT).show();
                        break;
                    }
                    case 3: {
                        Snackbar.make(findViewById(android.R.id.content),"Соединение не установлено",Snackbar.LENGTH_SHORT).show();
                        break;
                    }
                    case 4: {
                        Snackbar.make(findViewById(android.R.id.content),ApplicationState.getInstance().getName(),Snackbar.LENGTH_SHORT).show();
                        break;
                    }
                }
            };
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SocketManager manager = new SocketManager(getApplicationContext(),handler);
                manager.updateDB();
                //List<Ingredient> inComeList = manager.getNewIngredients();
            }
        });
        thread.start();

    }
}
