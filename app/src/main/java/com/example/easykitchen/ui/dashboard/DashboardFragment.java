package com.example.easykitchen.ui.dashboard;

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
import com.example.easykitchen.R;
import com.example.easykitchen.databinding.FragmentDashboardBinding;
import com.example.easykitchen.item;
import com.example.easykitchen.ui.home.menu_list;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    ListView serve_view;
    public ArrayList<item> serve_list,curr_menu;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        serve_view = root.findViewById(R.id.serve_list);

        curr_menu = menu_list.it_arr;
        serve_list = new ArrayList<>();
        for(int i =0;i<curr_menu.size();i++) {
            if (curr_menu.get(i).getStatus().charAt(0) == 'R') {
                serve_list.add(curr_menu.get(i));
            }
        }


        ListAdapter chefadapter = new ListAdapter(requireContext(),serve_list);
        serve_view.setAdapter(chefadapter);
        serve_view.setClickable(true);



        serve_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                new AlertDialog.Builder(requireContext())
                        .setIcon(R.drawable.ic_baseline_chef_24)
                        .setTitle("Served?")
                        .setMessage("Change status to Finished")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                change_curr(serve_list.get(which_item));
                                serve_list.remove(which_item);
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
                menu_list.it_arr.get(temp).setStatus("Completed");
            }
        }

    }
}