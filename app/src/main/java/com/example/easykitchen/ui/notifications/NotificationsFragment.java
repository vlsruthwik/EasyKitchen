package com.example.easykitchen.ui.notifications;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easykitchen.ListAdapter;
import com.example.easykitchen.MainScreen;
import com.example.easykitchen.R;
import com.example.easykitchen.databinding.FragmentNotificationsBinding;
import com.example.easykitchen.item;
import com.example.easykitchen.ui.home.menu_list;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    public ArrayList<item> chef_list,curr_menu;
    ListView chef_view;
    View view;
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



        chef_view = root.findViewById(R.id.chef_list);

        curr_menu = menu_list.it_arr;
        chef_list = new ArrayList<>();
        for(int i =0;i<curr_menu.size();i++) {
            if (curr_menu.get(i).getStatus().charAt(0) == 'F') {
                chef_list.add(curr_menu.get(i));
            }
        }


        ListAdapter chefadapter = new ListAdapter(requireContext(),chef_list);
        chef_view.setAdapter(chefadapter);
        chef_view.setClickable(true);



        chef_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                new AlertDialog.Builder(requireContext())
                        .setIcon(R.drawable.ic_baseline_chef_24)
                        .setTitle("Finished?")
                        .setMessage("Change status to serve")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                change_curr(chef_list.get(which_item));
                                chef_list.remove(which_item);
                                chefadapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
            }
        });

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void change_curr(item it){
        for(int i=0;i<menu_list.it_arr.size();i++){
            if(menu_list.it_arr.get(i)==it){
                int temp = menu_list.it_arr.indexOf(it);
                menu_list.it_arr.get(temp).setStatus("Ready to Serve");
            }
        }

    }
}