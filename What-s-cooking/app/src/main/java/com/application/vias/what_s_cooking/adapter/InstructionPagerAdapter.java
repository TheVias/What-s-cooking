package com.application.vias.what_s_cooking.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.application.vias.what_s_cooking.activity.InstructionFragment;
import com.application.vias.what_s_cooking.entity.Instruction;

import java.util.List;

/**
 * Адаптер фрагментов-инструкций
 */
public class InstructionPagerAdapter extends FragmentPagerAdapter {

    private List<Instruction> instructionList;

    public InstructionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        InstructionFragment fragment = new InstructionFragment();
        fragment.setInstruction(instructionList.get(position));
        fragment.setInstructionNumber(instructionList.get(position).getInstruction_num() - 1);
        return fragment;
    }

    @Override
    public int getCount() {
        return instructionList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position);
    }

    public void setInstructionList(List<Instruction> instructionList) {
        this.instructionList = instructionList;
    }

    @Override
    public int getItemPosition(Object object) {
        // Этот метод требуется для обновления фрагментов (используется в методе notifyDataSetChanged адаптера)
        return POSITION_NONE;
    }
}
