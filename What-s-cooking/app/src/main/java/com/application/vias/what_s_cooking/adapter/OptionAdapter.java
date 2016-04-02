package com.application.vias.what_s_cooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.application.vias.what_s_cooking.Option;
import com.application.vias.what_s_cooking.R;

import java.util.List;

/**
 * Created by andrey on 02.04.2016.
 */
public class OptionAdapter extends BaseAdapter {

    private List<Option> list;
    private LayoutInflater layoutInflater;

    public OptionAdapter(Context context, List<Option> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.option_layout, parent, false);
        }

        Option option = getOption(position);

        TextView titleView = (TextView) view.findViewById(R.id.titleView);
        TextView descriptionView = (TextView) view.findViewById(R.id.descriptionView);
        titleView.setText(option.getTitle());
        descriptionView.setText(option.getDescription());

        return view;
    }

    private Option getOption(int position) {
        return (Option) getItem(position);
    }
}
