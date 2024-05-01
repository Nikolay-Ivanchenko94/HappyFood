package com.example.happyfood.fragment.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentOnboarding2Binding;

public class Onboarding2Fragment extends Fragment {

    private FragmentOnboarding2Binding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    binding = FragmentOnboarding2Binding.inflate(inflater,container,false);


    binding.btnNext.setOnClickListener(v -> {
        OnBoarding3Fragment onBoarding3Fragment = new OnBoarding3Fragment();
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.container,onBoarding3Fragment,"findThisFragment").addToBackStack(null)
                .commit();
    });
    binding.btnCircle2.setOnClickListener(v -> {
        OnBoarding3Fragment onBoarding3Fragment = new OnBoarding3Fragment();
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.container,onBoarding3Fragment,"findThisFragment").addToBackStack(null)
                .commit();
    });

    binding.btnSkip.setOnClickListener(v -> {
        OnboardingFragment onboardingFragment = new OnboardingFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,onboardingFragment,"findThisFragment")
                .addToBackStack(null)
                .commit();
    });

    return  binding.getRoot();
    }
}