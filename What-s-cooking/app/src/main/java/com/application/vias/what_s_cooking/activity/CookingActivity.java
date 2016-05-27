package com.application.vias.what_s_cooking.activity;

import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.adapter.InstructionPagerAdapter;
import com.application.vias.what_s_cooking.CookingTimer;
import com.application.vias.what_s_cooking.entity.Dish;
import com.application.vias.what_s_cooking.entity.Instruction;
import com.application.vias.what_s_cooking.view.TimerView;

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
    CookingTimer cookingTimer;

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

            // Ставим заголовок название нашего блюда
            setTitle(dish.getName());
            // Вытаскиваем инструкции для приготовления нашего блюда
            listInstructions = dish.getInstructions();

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
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            // Инициализируем таймер
            Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);
            TimerView timerView = (TimerView) findViewById(R.id.timer_view);
            cookingTimer = new CookingTimer();
            cookingTimer.initTimer(this,chronometer,timerView);

        } else {
            // Если мы ничего не готовим, то отправляем на главное активити
            goToNewActivity(MainActivity.class);
        }
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

    public void startTimer(View view) {
        //Toast.makeText(this,String.valueOf(mViewPager.getCurrentItem()),Toast.LENGTH_SHORT).show();
        Fragment fragment = instructionsPagerAdapter.getItem(mViewPager.getCurrentItem());
        Instruction instruction = ((InstructionFragment) fragment).getInstruction();
        // TODO: не работает - магия????
        view.setEnabled(false);
        instructionsPagerAdapter.notifyDataSetChanged();
        cookingTimer.startTimer(instruction.getTimer());
    }

}
