package com.application.vias.what_s_cooking.adapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.application.vias.what_s_cooking.Category;
import com.application.vias.what_s_cooking.Ingredient;
import com.application.vias.what_s_cooking.R;

import java.util.HashMap;
import java.util.List;

/**
 * Класс-адаптер двухуровнего списка: ингредиенты по категориям
 */
public class IngredientsInCategoriesAdapter extends BaseExpandableListAdapter{

    LayoutInflater layoutInflater;
    private List<Pair<Category, List<Ingredient>>> group;
    private Context context;

    /**
     * Обычный конструктор
     * @param context контекст приложения
     * @param group список группа
     */
    public IngredientsInCategoriesAdapter(Context context, List<Pair<Category,List<Ingredient>>> group) {
        this.context = context;
        this.group = group;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return group.get(groupPosition).second.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return group.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return group.get(groupPosition).second.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        //return false;
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.category_layout, parent, false);
        }

        if (isExpanded){
            //Изменяем что-нибудь, если текущая Group раскрыта
        }
        else{
            //Изменяем что-нибудь, если текущая Group скрыта
        }

        Category category = ((Pair<Category, List<Ingredient>>) getGroup(groupPosition)).first;

        TextView categoryName = (TextView) convertView.findViewById(R.id.category_name);
        categoryName.setText(category.getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.ingredient_in_category_layout, parent, false);
        }

        Ingredient ingredient = (Ingredient) getChild(groupPosition,childPosition);

        TextView ingredientName = (TextView) convertView.findViewById(R.id.ingredient_name);
        ingredientName.setText(ingredient.getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        //return false;
        return true;
    }
}
