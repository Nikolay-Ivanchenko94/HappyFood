package com.example.happyfood.fragment.logins;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentForgotBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class ForgotFragment extends Fragment {

    private FragmentForgotBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentForgotBinding.inflate(inflater,container,false);

        binding.btnSubmit.setOnClickListener(v -> {
            if (binding.evEmail.getText().toString().isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(),
                        "Fields is empty",Toast.LENGTH_LONG).show();
            } else {
                FirebaseAuth.getInstance()
                        .sendPasswordResetEmail(binding.evEmail.
                                getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    HashMap<String,String > userInfo = new HashMap<>();
                                    userInfo.put("email",binding.evEmail.getText().toString());
                                    FirebaseDatabase.getInstance().getReference().child("Users").
                                            child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(userInfo);

                                   ResetFragment resetFragment = new ResetFragment();
                                   getActivity().getSupportFragmentManager().
                                           beginTransaction().replace(R.id.container,resetFragment,
                                                   "findThisFragment").addToBackStack(null)
                                           .commit();
                                }
                            }
                        });
               binding.btnBack.setOnClickListener(v1 -> {
                   SignUpFragment signUpFragment = new SignUpFragment();
                   getActivity().getSupportFragmentManager().beginTransaction().
                           replace(R.id.container,signUpFragment,
                                   "findThisFragment").addToBackStack(null)
                           .commit();
               });
            }

        });


       return binding.getRoot();


    }
}