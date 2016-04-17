package com.application.vias.what_s_cooking.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.entity.Ingredient;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.IngredientAdapterRV;

import java.util.ArrayList;
import java.util.List;

/**
 * Активити со списком ингредиентов, из которых следует приготовить блюдо. Можно добавлять ингредиенты,
 * удалять их или отправиться к выбору блюда по существующему списку ингредиентов.
 */
public class LinkActivity extends AbstractActivity {

    private List<Ingredient> listIngredient;
    private IngredientAdapterRV adapterRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.AppDefault);
        //устанавливаем заголовок тулбара
        setTitle(R.string.link_activity_title);
        setContentView(R.layout.activity_link);

        initIngredientsList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewActivity(AllCategoriesActivity.class);
            }
        });

        FloatingActionButton fab_confirm = (FloatingActionButton) findViewById(R.id.fab_confirm);
        fab_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Набор составлен!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        initIngredientsList();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        ApplicationState state = ApplicationState.getInstance();
        state.setIngredientList(listIngredient);
        super.onDestroy();
    }

    //Методы вызывается при инициализации пунктов меню. Меню представляет собой R.menu.menu_link_activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_link_activity, menu);
        return true;
    }

    //Метод вызывается при клике на элемент меню, по айдишнику элемента определяем куда кликнули и обрабатываем соответственно
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /*
            case R.id.item_complete:
                Toast.makeText(getApplicationContext(), "Набор составлен!", Toast.LENGTH_SHORT).show();
                //listIngredient.add(new Ingredient(listIngredient.size() + 1, "Морковка", "Овощи"));
                //refreshIngredientsList();
                return true;
            */
            case R.id.item_back: {
                //goToNewActivity(MainActivity.class);
                finish();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Метод инициализирует список ингридиентов
     */
    private void initIngredientsList() {
        ApplicationState state = ApplicationState.getInstance();
        //listIngredientView = (ListView) findViewById(R.id.listIngredients);
        if (state.getIngredientList().isEmpty()) {
            listIngredient = new ArrayList<Ingredient>();
            //listIngredient.add(new Ingredient(1,"tttt",1));
        } else {
            listIngredient = state.getIngredientList();
        }
        //IngredientAdapter adapter = new IngredientAdapter(this,listIngredient);
        //listIngredientView.setAdapter(adapter);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapterRV = new IngredientAdapterRV(listIngredient);
        recyclerView.setAdapter(adapterRV);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                //Remove swiped item from list and notify the RecyclerView
                Snackbar.make(viewHolder.itemView,listIngredient.get(viewHolder.getAdapterPosition()).getName()+" был удален",Snackbar.LENGTH_SHORT).show();
                listIngredient.remove(viewHolder.getAdapterPosition());
                adapterRV.notifyItemRemoved((int)viewHolder.getAdapterPosition());
            }


            /*
            //метод делает фон элемента красным (указывая на удаление)
            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    // Get RecyclerView item from the ViewHolder
                    View itemView = viewHolder.itemView;

                    Paint p = new Paint();
                    p.setColor(Color.RED);
                    if (dX > 0) {
                        // Draw Rect with varying right side, equal to displacement dX
                        c.drawRect((float) itemView.getLeft(), (float) itemView.getTop(), dX,
                                (float) itemView.getBottom(), p);
                    } else {
                    // Draw Rect with varying left side, equal to the item's right side plus negative displacement dX
                        c.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop(),
                                (float) itemView.getRight(), (float) itemView.getBottom(), p);
                    }

                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }
            }
            */
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);

        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

}
