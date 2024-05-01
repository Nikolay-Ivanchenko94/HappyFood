package com.example.happyfood.fragment.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentOnBoarding3Binding;


public class OnBoarding3Fragment extends Fragment {

    private FragmentOnBoarding3Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOnBoarding3Binding.inflate(inflater,container,false);

        binding.btnNext.setOnClickListener(v -> {
            OnboardingFragment onboardingFragment = new OnboardingFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,onboardingFragment
                    ,"findThisFragment").addToBackStack(null)
                    .commit();
        });

        binding.btnCircle3.setOnClickListener(v -> {
            OnboardingFragment onboardingFragment = new OnboardingFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,onboardingFragment
                            ,"findThisFragment").addToBackStack(null)
                    .commit();
        });
        binding.btnSkip.setOnClickListener(v -> {
            OnboardingFragment onboardingFragment = new OnboardingFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,onboardingFragment
                            ,"findThisFragment").addToBackStack(null)
                    .commit();
        });
        return  binding.getRoot();
    }
}