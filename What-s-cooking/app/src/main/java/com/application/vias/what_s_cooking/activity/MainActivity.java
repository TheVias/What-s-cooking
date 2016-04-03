package com.application.vias.what_s_cooking.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.Option;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.OptionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 02.04.2016.
 */
public class MainActivity extends AbstractActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
        initOptionMenu();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        goToNewActivity(LinkActivity.class);
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),R.string.option2,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),R.string.option3,Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    @Override
    void initToolbar() {
        toolbar =  (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.drawable.app_icon);
    }

    private void initOptionMenu() {
        listView = (ListView) findViewById(R.id.listMenu);
        List<Option> list = new ArrayList<Option>();
        list.add(new Option(1,getString(R.string.option1),getString(R.string.option1_description)));
        list.add(new Option(2,getString(R.string.option2),getString(R.string.option2_description)));
        list.add(new Option(3,getString(R.string.option3),getString(R.string.option3_description)));
        OptionAdapter adapter = new OptionAdapter(this,list);
        listView.setAdapter(adapter);
    }


}
