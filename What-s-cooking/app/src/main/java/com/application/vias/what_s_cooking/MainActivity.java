package com.application.vias.what_s_cooking;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * Created by andrey on 02.04.2016.
 */
public class MainActivity extends Activity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.app_icon);
    }
}
