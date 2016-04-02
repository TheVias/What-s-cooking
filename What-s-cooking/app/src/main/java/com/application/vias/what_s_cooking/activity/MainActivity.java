package com.application.vias.what_s_cooking.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.application.vias.what_s_cooking.Option;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.OptionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 02.04.2016.
 */
public class MainActivity extends Activity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initOptionMenu();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.app_icon);
    }

    private void initOptionMenu() {
        listView = (ListView) findViewById(R.id.listMenu);
        List<Option> list = new ArrayList<Option>();
        list.add(new Option(1,getString(R.string.option1),getString(R.string.option1_description)));
        list.add(new Option(2,getString(R.string.option2),getString(R.string.option2_description)));
        list.add(new Option(3,getString(R.string.option3),getString(R.string.option3_description)));
        OptionAdapter optionAdapter = new OptionAdapter(this,list);
        listView.setAdapter(optionAdapter);
    }
}
