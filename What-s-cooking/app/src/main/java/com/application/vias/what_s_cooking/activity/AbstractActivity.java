package com.application.vias.what_s_cooking.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.application.vias.what_s_cooking.Option;
import com.application.vias.what_s_cooking.R;

import java.util.ArrayList;

abstract class AbstractActivity extends Activity {

    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract void initToolbar();

    protected void goToNewActivity(Class gotoActivity) {
        Intent intent = new Intent(this,gotoActivity);
        startActivity(intent);
    }
}
