package com.application.vias.what_s_cooking.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.Ingredient;
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
    //protected android.widget.Toolbar toolbar;
    //
    //
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mDatabaseHelper = new DatabaseHelper(this, "database.db", null, 1);
        SQLiteDatabase sdb;
        sdb = mDatabaseHelper.getReadableDatabase();



        super.onCreate(savedInstanceState);
        //setTheme(R.style.AppDefault);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);

        initOptionsList();
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

    private void initOptionsList() {
        listView = (ListView) findViewById(R.id.listMenu);
        List<Option> list = new ArrayList<Option>();
        list.add(new Option(1,getString(R.string.option1),getString(R.string.option1_description)));
        list.add(new Option(2,getString(R.string.option2),getString(R.string.option2_description)));
        list.add(new Option(3, getString(R.string.option3), getString(R.string.option3_description)));
        OptionAdapter adapter = new OptionAdapter(this,list);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
        MenuItem locationItem = menu.add(0, R.id.menu_location, 0, R.string.menu_location);
        locationItem.setIcon(R.drawable.ic_action_location);
        MenuItemCompat.setShowAsAction(locationItem, MenuItem.SHOW_AS_ACTION_IF_ROOM);
        */
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_settings:
                Toast.makeText(getApplicationContext(), "Настройки", Toast.LENGTH_SHORT).show();
                goToNewActivity(LauncherActivity.class);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
