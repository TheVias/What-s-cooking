package com.application.vias.what_s_cooking.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.vias.what_s_cooking.Category;
import com.application.vias.what_s_cooking.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Класс-адаптер списка категорий, заполняет поля layout-а названием категории и
 * задает цвет маркеру R.id.category_image соответствующему категории цвету
 */
public class CategoryAdapter extends BaseAdapter {

    private List<Category> list;
    LayoutInflater layoutInflater;
    Context context;

    public CategoryAdapter(Context context, List<Category> list) {
        this.list = list;
        this.context = context;
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
            view = layoutInflater.inflate(R.layout.category_layout,parent,false);
        }

        Category category = (Category) getItem(position);

        TextView categoryName = (TextView) view.findViewById(R.id.category_name);
        categoryName.setText(category.getName());
        /*
        ImageView categoryImage = (ImageView) view.findViewById(R.id.category_image);
        categoryImage.setColorFilter(new LightingColorFilter(0xff4081, 0xff4081));
        */

        return view;
    }
}
