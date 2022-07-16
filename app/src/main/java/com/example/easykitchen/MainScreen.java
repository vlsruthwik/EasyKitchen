package com.example.easykitchen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.easykitchen.ui.home.menu_list;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.easykitchen.databinding.ActivityMainScreenBinding;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    private ActivityMainScreenBinding binding;

    public ListView cust_view,serve_view,chef_view;
    public ArrayList<item> curr_menu,chef_list,serve_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_screen);

        NavigationUI.setupWithNavController(binding.navView, navController);

        cust_view = findViewById(R.id.cust_list);
        chef_view = (ListView) findViewById(R.id.chef_list);
        curr_menu = menu_list.it_arr;



        ListAdapter listAdapter = new ListAdapter(this,curr_menu);
        cust_view.setAdapter(listAdapter);

    }

    public void add_open(View add) {
        startActivity(new Intent(MainScreen.this,menu_list.class));
    }

    public void generate_bill(View view) {
        int Total = 0;
        for (item i : menu_list.it_arr) {
            Total+=i.getCost()*i.getQuant();
        }
        AlertDialog altr = new AlertDialog.Builder(this).create();
        altr.setTitle("Toatal Bill");
        altr.setMessage("₹ "+Total);
        altr.setButton("PAY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);

            }
        });
        altr.show();

    }




}