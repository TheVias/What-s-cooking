package com.application.vias.what_s_cooking.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.entity.Instruction;

/**
 * Класс инструкции-фрагмента. Отвечает за отрисовку этапа готовки
 */
public class InstructionFragment extends Fragment {
    private Instruction instruction;
    private int instructionNumber;

    public InstructionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cooking, container, false);
        TextView numberView = (TextView) rootView.findViewById(R.id.instruction_number);
        numberView.setText(getString(R.string.step)+" "+String.valueOf(instructionNumber));
        TextView descriptionView = (TextView) rootView.findViewById(R.id.instruction_description);
        descriptionView.setText(instruction.getDescription());
        return rootView;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public int getInstructionNumber() {
        return instructionNumber;
    }

    public void setInstructionNumber(int instructionNumber) {
        this.instructionNumber = instructionNumber;
    }
}
