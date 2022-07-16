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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_card,parent,false);

        }
        ImageView img = convertView.findViewById(R.id.dish_photo);
        TextView dish = convertView.findViewById(R.id.dish);
        TextView quant = convertView.findViewById(R.id.quant_field);
        TextView cost = convertView.findViewById(R.id.price);

        img.setImageResource(it.imgID);
        dish.setText(it.dish_name);
        quant.setText(it.quant);
        cost.setText(it.cost);

//         return super.getView(position, convertView, parent);
        return convertView;
    }
}
