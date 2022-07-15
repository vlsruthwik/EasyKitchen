package com.example.easykitchen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    ActivityMainScreenBinding binding;




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


    }

    public void add_open(View add) {
        startActivity(new Intent(MainScreen.this,menu_list.class));
    }



}