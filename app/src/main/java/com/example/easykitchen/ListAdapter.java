package com.example.easykitchen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends ArrayAdapter<item> {

    public ListAdapter(Context context, ArrayList<item> menuList){
        super(context,0,menuList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        item it = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cust_orders,parent,false);

        }

        TextView dish_name = convertView.findViewById(R.id.curr_dish_name);
        TextView dish_quant = convertView.findViewById(R.id.curr_dish_quant);
        TextView dish_status = convertView.findViewById(R.id.curr_dish_status);

        dish_name.setText(it.getDish_name());
        dish_quant.setText(String.valueOf(it.getQuant()));
        dish_status.setText(it.getStatus());

//         return super.getView(position, convertView, parent);
        return convertView;
    }
}
