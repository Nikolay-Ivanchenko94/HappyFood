package com.example.happyfood.fragment.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentLogoBinding;
import com.example.happyfood.fragment.onboarding.OnboardingScreen1Fragment;


public class LogoFragment extends Fragment {

    private FragmentLogoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLogoBinding.inflate(inflater,container,false);


        binding.btnNext.setOnClickListener(v -> {
            OnboardingScreen1Fragment onbordingScreen1Fragment = new OnboardingScreen1Fragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,onbordingScreen1Fragment,
                    "findTHisFragment").addToBackStack(null)
                    .commit();
        });

        return binding.getRoot();
    }
}