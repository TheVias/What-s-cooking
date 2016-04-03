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

abstract class AbstractActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //abstract void initToolbar();

    protected void goToNewActivity(Class gotoActivity) {
        Intent intent = new Intent(this,gotoActivity);
        startActivity(intent);
    }
}
