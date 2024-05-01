package com.example.happyfood.fragment.logins;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentReset2Binding;
import com.example.happyfood.databinding.FragmentResetBinding;
import com.example.happyfood.fragment.screen.HomeFragment;


public class ResetFragment2 extends Fragment {

   private FragmentReset2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentReset2Binding.inflate(inflater,container,false);


      binding.btnGoHome.setOnClickListener(v -> {
          HomeFragment homeFragment = new HomeFragment();
          getActivity().getSupportFragmentManager().beginTransaction().
                  replace(R.id.container,homeFragment,"findThisFragment").
                  addToBackStack(null).commit();
      });


      return  binding.getRoot();
    }
}