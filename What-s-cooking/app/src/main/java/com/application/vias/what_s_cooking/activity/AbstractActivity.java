package com.application.vias.what_s_cooking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.application.vias.what_s_cooking.R;

import java.util.ArrayList;

/**
 * Базовый класс для всех классов с тулбаром (наследуемся от AppCompatActivity, потому что там
 * встроенный бар и его не нужно явно прописывать в xml файле)
 */
abstract class AbstractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Метод, который запускает новое активити
     * @param gotoActivity класс активити, на которое следует перейти
     */
    protected void goToNewActivity(Class gotoActivity) {
        Intent intent = new Intent(this,gotoActivity);
        startActivity(intent);
    }
}
