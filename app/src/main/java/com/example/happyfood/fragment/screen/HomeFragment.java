package com.example.happyfood.fragment.screen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      
        binding = FragmentHomeBinding.inflate(inflater,container,false);


        binding.btnFood.setOnClickListener(v -> {
            FoodFragment foodFragment = new FoodFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    foodFragment,"findThisFragment")
                    .addToBackStack(null)
                    .commit();
        });


        binding.btnGroceries.setOnClickListener(v -> {
            GroceriesFragment groceriesFragment = new GroceriesFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    groceriesFragment,"findThisFragment").addToBackStack(null)
                    .commit();
        });
        binding.btnHome.setOnClickListener(v -> {
            HomeFragment homeFragment = new HomeFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,homeFragment,
                            "findThisFragment").addToBackStack(null)
                    .commit();
        });

        binding.btnProfile.setOnClickListener(v -> {
            UserFragment userFragment = new UserFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,userFragment,"ThisFragment")
                    .addToBackStack(null).commit();
        });

        return binding.getRoot();
    }



}