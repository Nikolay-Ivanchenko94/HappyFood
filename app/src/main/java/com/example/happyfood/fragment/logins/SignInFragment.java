package com.example.happyfood.fragment.logins;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentSignInBinding;
import com.example.happyfood.fragment.onboarding.OnboardingFragment;
import com.example.happyfood.fragment.screen.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignInFragment extends Fragment {

private FragmentSignInBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignInBinding.inflate(inflater,container,false);

        binding.btnBack.setOnClickListener(v -> {
            OnboardingFragment onboardingFragment = new OnboardingFragment();
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.container,onboardingFragment,
                            "findThisFragment").addToBackStack(null)
                    .commit();
        });
        binding.btnSignIn.setOnClickListener(v -> {
            if (binding.evEmail.getText().toString().isEmpty()
                    || binding.evPsw.getText().toString().isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(),
                        "Fields cannot be empty",Toast.LENGTH_LONG).show();
            } else {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.evPsw.getText().toString(),
                        binding.evEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    HomeFragment homeFragment = new HomeFragment();
                                    getActivity().getSupportFragmentManager().
                                            beginTransaction().replace(R.id.container,
                                                    homeFragment,"findThisFragment")
                                            .addToBackStack(null).commit();
                                }
                            }
                        });
            }
        });
        binding.btnForgot.setOnClickListener(v -> {
            ForgotFragment forgotFragment = new ForgotFragment();
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.container,forgotFragment,"findTisFragment")
                    .addToBackStack(null).commit();
        });


        return binding.getRoot();
    }
}