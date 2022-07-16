package com.example.easykitchen.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.easykitchen.ListAdapter;
import com.example.easykitchen.MainScreen;
import com.example.easykitchen.R;
import com.example.easykitchen.databinding.ActivityMainBinding;
import com.example.easykitchen.databinding.ActivityMainScreenBinding;
import com.example.easykitchen.databinding.ActivityMenuListBinding;
import com.example.easykitchen.item;

import java.util.ArrayList;

public class menu_list extends AppCompatActivity {

    ActivityMenuListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_menu_list);

        int[] img_arr = {R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,
                R.drawable.h,
                R.drawable.i,
                R.drawable.j};

        String[] dishes = {"Tomato Soup","Panner Manchurian","Veg Biryani","Veg Fried Rice","South Indian Thali","Panner Butter Masala","Butter Naan","Chocolate Cake","Vanilla Ice-cream","Butter Milk"};
        String[] cost = {"129","269","275","229","199","299","50","599","169","40"};
        String[] quant = {"0","0","0","0","0","0","0","0","0","0"};


        ArrayList<item> it_arr = new ArrayList<item>();

        for(int i=0;i<img_arr.length;i++){
            item it = new item(dishes[i],cost[i],quant[i],img_arr[i]);
            it_arr.add(it);
        }

        ListAdapter listAdapter = new ListAdapter(this,it_arr);
//        binding.menuList.setAdapter(listAdapter);
        ListView menu = findViewById(R.id.menu_list);
        menu.setAdapter(listAdapter);


    }


    public void menu_close(View view) {
        this.finish();
    }
}