package com.example.easykitchen.ui.home;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easykitchen.R;
import com.example.easykitchen.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

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
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showMenu(){
        dialogBuilder = new AlertDialog.Builder(getActivity());
        final View contactpopupview = getLayoutInflater().inflate(R.layout.menu_popup,null);
        dialogBuilder.setView(contactpopupview);

        dialog = dialogBuilder.create();
        dialog.show();


    }

    




}