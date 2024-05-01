package com.example.happyfood.fragment.screen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentGroceriesBinding;

public class GroceriesFragment extends Fragment {

private FragmentGroceriesBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentGroceriesBinding.inflate(inflater,container,false);

        binding.btnGrape.setOnClickListener(v -> {
            DetailsGrapeFragment detailsGrapeFragment = new DetailsGrapeFragment();
            getActivity().getSupportFragmentManager()
                    .beginTransaction().replace(R.id.container,
                            detailsGrapeFragment,
                            "findThisFragment").addToBackStack(null).commit();
        });




        return binding.getRoot();
    }
}