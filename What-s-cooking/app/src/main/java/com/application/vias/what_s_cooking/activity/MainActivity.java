package com.application.vias.what_s_cooking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.DatabaseHelper;
import com.application.vias.what_s_cooking.Option;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.OptionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс активити главного меню с выбором действий
 */
public class MainActivity extends AbstractActivity {

    private ListView listView;
    //protected android.widget.Toolbar toolbar;
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
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
                        Intent intent1 = new Intent(getApplicationContext(),RecipeRVActivity.class);
                        intent1.putExtra("action","show_all");
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getApplicationContext(),RecipeRVActivity.class);
                        intent2.putExtra("action","show_favorite");
                        startActivity(intent2);
                        break;
                }
            }
        });

    }

    /**
     * Инициализация списка элементов главного меню
     */
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
                //Toast.makeText(getApplicationContext(), "Настройки", Toast.LENGTH_SHORT).show();
                goToNewActivity(AboutActivity.class);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
