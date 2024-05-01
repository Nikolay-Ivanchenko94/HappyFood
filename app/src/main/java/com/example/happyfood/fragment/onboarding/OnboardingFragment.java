package com.example.happyfood.fragment.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentOnboardingBinding;
import com.example.happyfood.fragment.logins.SignInFragment;
import com.example.happyfood.fragment.logins.SignUpFragment;


public class OnboardingFragment extends Fragment {

    private FragmentOnboardingBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentOnboardingBinding.inflate(inflater,container,false);

        binding.btnSignUp.setOnClickListener(v -> {
            SignUpFragment signUpFragment = new SignUpFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    signUpFragment,"findThisFragment")
                    .addToBackStack(null).commit();
        });

        binding.btnSignIn.setOnClickListener(v -> {
            SignInFragment signInFragment = new SignInFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            signInFragment,"findThisFragment")
                    .addToBackStack(null).commit();
        });

        return  binding.getRoot();
    }
}