package com.example.happyfood.fragment.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentOnbordingScreen1Binding;


public class OnboardingScreen1Fragment extends Fragment {


    private FragmentOnbordingScreen1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnbordingScreen1Binding.inflate(inflater,container,false);

        binding.btnSkip.setOnClickListener(v -> {
            OnboardingFragment onboardingFragment = new OnboardingFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    onboardingFragment,"findThisFragment").addToBackStack(null)
                    .commit();
        });

        binding.btnNext.setOnClickListener(v -> {
            Onboarding2Fragment onboarding2Fragment = new Onboarding2Fragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    onboarding2Fragment,"findThisFragment").addToBackStack(null)
                    .commit();
        });
        binding.btnCircle.setOnClickListener(v -> {
            Onboarding2Fragment onboarding2Fragment = new Onboarding2Fragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            onboarding2Fragment,"findThisFragment").addToBackStack(null)
                    .commit();
        });



        return binding.getRoot();
    }
}