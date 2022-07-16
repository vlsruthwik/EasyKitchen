package com.example.easykitchen.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easykitchen.ListAdapter;
import com.example.easykitchen.MainActivity;
import com.example.easykitchen.MainScreen;
import com.example.easykitchen.R;
import com.example.easykitchen.databinding.FragmentHomeBinding;
import com.example.easykitchen.item;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView cust_view;
    ArrayList<item> curr_menu;
    private FragmentHomeBinding binding;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    Button ad,cl;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        cust_view = root.findViewById(R.id.cust_list);
        curr_menu = menu_list.it_arr;

        ListAdapter listAdapter = new ListAdapter(getContext(),curr_menu);
        cust_view.setAdapter(listAdapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}