package com.example.easykitchen.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView dn,dc;
    EditText et;

    int[] dish_name={R.id.dish_name1,
            R.id.dish_name2,
            R.id.dish_name3,
            R.id.dish_name4,
            R.id.dish_name5,
            R.id.dish_name6,
            R.id.dish_name7,
            R.id.dish_name8,
            R.id.dish_name9,
            R.id.dish_name10
    };
    int[] dish_cost={R.id.dish_cost1,
            R.id.dish_cost2,
            R.id.dish_cost3,
            R.id.dish_cost4,
            R.id.dish_cost5,
            R.id.dish_cost6,
            R.id.dish_cost7,
            R.id.dish_cost8,
            R.id.dish_cost9,
            R.id.dish_cost10
    };
    int[] dish_quants={R.id.quant_field1,
            R.id.quant_field2,
            R.id.quant_field3,
            R.id.quant_field4,
            R.id.quant_field5,
            R.id.quant_field6,
            R.id.quant_field7,
            R.id.quant_field8,
            R.id.quant_field9,
            R.id.quant_field10
    };
    public static ArrayList<item> it_arr = new ArrayList<item>();

    String[] dishes = {"Tomato Soup","Panner Manchurian","Veg Biryani","Veg Fried Rice","South Indian Thali","Panner Butter Masala","Butter Naan","Chocolate Cake","Vanilla Ice-cream","Butter Milk"};
    int[] cost = {129,269,275,229,199,299,50,599,169,40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuListBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_menu_list);


        for(int i=0;i<dishes.length;i++){
            dn = findViewById(dish_name[i]);
            dc = findViewById(dish_cost[i]);
            dn.setText(dishes[i]);
            dc.setText("₹ "+cost[i]);
        }

    }


    public void menu_close(View view) {
        this.finish();
    }


    public void order_these(View view) {
        for(int i=0;i<dish_quants.length;i++){
            et = findViewById(dish_quants[i]);
            String s =et.getText().toString();
            if(s.length()>0){
                item it = new item(dishes[i],cost[i],Integer.parseInt(s),"Food is Processing");
                it_arr.add(it);
            }
        }

        startActivity(new Intent(menu_list.this,MainScreen.class));
    }
}