package com.application.vias.what_s_cooking.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.InstructionPagerAdapter;
import com.application.vias.what_s_cooking.entity.Dish;
import com.application.vias.what_s_cooking.entity.Instruction;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-активити готовки блюда
 */
public class CookingActivity extends AbstractActivity {

    // Адаптер наших инструкций
    private InstructionPagerAdapter instructionsPagerAdapter;

    // ViewPager, который будет отображать наши фрагменты
    private ViewPager mViewPager;

    private ProgressBar progressBar;
    private FloatingActionButton fab;
    private int currentInstructionNumber;
    private List<Instruction> listInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cooking_activity);
        ApplicationState state = ApplicationState.getInstance();
        Dish dish;
        // Каким-то образом получаем то блюдо, которое должны готовить
        if (state.getDish() != null) {
            // Если мы уже что-то готовили, то продолжаем
            dish = state.getDish();
            currentInstructionNumber = state.getInstructionNumber();
        } else {
            // TODO: Если мы ничего не готовим, то отправляем на главное активити
            // Пока что заглушка:
            dish = state.getHelper().getDishesByIngredients(state.getHelper().getAllIngredients()).get(0);
            currentInstructionNumber = 0;
            // Записываем в стейт, что у нас началась готовочка
            state.setDish(dish);
            state.setInstructionNumber(currentInstructionNumber);
        }
        // Ставим заголовок название нашего блюда
        setTitle(dish.getName());
        // Вытаскиваем инструкции для приготовления нашего блюда
        listInstructions = state.getHelper().getInstructionsByDish(dish);

        // Создаем адаптер, в который отдаем список инструкций
        instructionsPagerAdapter = new InstructionPagerAdapter(getSupportFragmentManager());
        instructionsPagerAdapter.setInstructionList(listInstructions);

        // Устанавливаем ViewPager наш адаптер
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(instructionsPagerAdapter);
        mViewPager.setCurrentItem(currentInstructionNumber, true);

        // Устанавливаем текущее значение прогресс бара
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setProgress(currentInstructionNumber*100 / listInstructions.size());

        // Кнопка перемотки на текущий этап
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(currentInstructionNumber, true);
            }
        });
        fab.hide();

        // Этот листнер слушает переключение этапов готовки и сохраняет в state номер текущего
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (currentInstructionNumber != mViewPager.getCurrentItem()) {
                    fab.show();
                } else {
                    fab.hide();
                }
                /*
                currentInstructionNumber = position;
                ApplicationState.getInstance().setInstructionNumber(currentInstructionNumber);
                progressBar.setProgress(currentInstructionNumber*100 / listInstructions.size());
                Toast.makeText(getApplicationContext(),String.valueOf(listInstructions.size()),Toast.LENGTH_SHORT);
                */
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_link_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void instructionComplete(View view) {
        ApplicationState state = ApplicationState.getInstance();
        if (mViewPager.getCurrentItem() == state.getInstructionNumber()) {
            currentInstructionNumber = mViewPager.getCurrentItem() + 1;
            state.setInstructionNumber(currentInstructionNumber);
            progressBar.setProgress(currentInstructionNumber*100 / listInstructions.size());
            Button instructionCompleteBtn;
            view.setEnabled(false);
            if (currentInstructionNumber == listInstructions.size()) {
                progressBar.setProgress(100);
                //Toast.makeText(getApplicationContext(),"БЛЮДО ГОТОВО",Toast.LENGTH_SHORT).show();
                goToNewActivity(RatingActivity.class);
            } else {
                instructionCompleteBtn = (Button) mViewPager.getChildAt(currentInstructionNumber).findViewById(R.id.instruction_complete);
                instructionCompleteBtn.setEnabled(true);
            }
            instructionsPagerAdapter.notifyDataSetChanged();
            mViewPager.setCurrentItem(currentInstructionNumber,true);
        }
    }

}
