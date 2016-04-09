package com.application.vias.what_s_cooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.application.vias.what_s_cooking.ApplicationState;
import com.application.vias.what_s_cooking.Ingredient;
import com.application.vias.what_s_cooking.R;
import com.application.vias.what_s_cooking.activity.DatabaseHelper;
import com.application.vias.what_s_cooking.activity.LinkActivity;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Класс-адаптер списка ингридиентов, заполняет поля layout-а ингредиентов данными
 */
public class IngredientAdapter extends BaseAdapter {

    private List<Ingredient> list;
    private LayoutInflater layoutInflater;
    private Context context;

    public IngredientAdapter(Context context, List<Ingredient> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
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

    //Метод, возвращающий view каждого отдельно взятого элемента списка
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = layoutInflater.inflate(R.layout.ingredient_layout, parent, false);
        }

        //получаем ингредиент
        Ingredient ingredient = getIngredient(position);

        ApplicationState state = ApplicationState.getInstance();
        DatabaseHelper helper = state.getHelper();

        //Заполняем поля layout-а
        TextView ingredientName = (TextView) view.findViewById(R.id.ingredient_name);
        ingredientName.setText(ingredient.getName());
        TextView ingredientDescription = (TextView) view.findViewById(R.id.ingredient_description);
        ingredientDescription.setText(helper.getCategoryById(ingredient.getCategory()).getName());

        return view;
    }

    /**
     * Возвращает ингредиент по позиции в списке
     * @param position позиция
     * @return ингредиент
     */
    private Ingredient getIngredient(int position) {
        return (Ingredient)getItem(position);
    }
}
