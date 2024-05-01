package com.example.happyfood.fragment.screen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentDetailsGrapeBinding;

public class DetailsGrapeFragment extends Fragment {


    private FragmentDetailsGrapeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       binding = FragmentDetailsGrapeBinding.inflate(inflater,container,false);

       return binding.getRoot();


    }

}