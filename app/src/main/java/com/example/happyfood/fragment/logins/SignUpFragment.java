package com.example.happyfood.fragment.logins;

import static android.app.ProgressDialog.show;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentOnboardingBinding;
import com.example.happyfood.databinding.FragmentSignUpBinding;
import com.example.happyfood.fragment.onboarding.OnboardingFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       binding = FragmentSignUpBinding.inflate(inflater,container,false);



       binding.btnForgot.setOnClickListener(v -> {
           ForgotFragment forgotFragment  = new ForgotFragment();
           getActivity().getSupportFragmentManager().beginTransaction().
                   replace(R.id.container,forgotFragment,"findThisFragment")
                   .addToBackStack(null)
                   .commit();
       });

       binding.btnSignUp.setOnClickListener(v -> {
           if (binding.evName.getText().toString().isEmpty() || binding.evEmail.getText().toString().isEmpty()
                   || binding.evCall.getText().toString().isEmpty()
                   || binding.evPsw.getText().toString().isEmpty()) {
               Toast.makeText(getActivity().getApplicationContext(),
                       "Fields cannot be empty",Toast.LENGTH_LONG).show();
           } else {
               FirebaseAuth.getInstance().
                       createUserWithEmailAndPassword
                               (binding.evPsw.getText().toString(),
                                       binding.evEmail.getText().toString())
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   FirebaseAuth auth = FirebaseAuth.getInstance();
                                   FirebaseUser firebaseUser = auth.getCurrentUser();
                                   HashMap<String,String > userInfo = new HashMap<>();
                                   userInfo.put("email",binding.evEmail.getText().toString());
                                   userInfo.put("psw",binding.evPsw.getText().toString());


                                   FirebaseDatabase.getInstance().getReference().child("Users").
                                           child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                           .setValue(userInfo);

                                   SignInFragment signInFragment = new SignInFragment();
                                   getActivity().getSupportFragmentManager()
                                           .beginTransaction().replace(R.id.container,signInFragment,
                                                   "findThisFragment").addToBackStack(null)
                                           .commit();
                               }
                           }
                       });

           }
       });
       binding.btnBack.setOnClickListener(v -> {
           OnboardingFragment onboardingFragment = new OnboardingFragment();
           getActivity().getSupportFragmentManager().beginTransaction().
                   replace(R.id.container,onboardingFragment,
                           "findThisFragment").addToBackStack(null)
                   .commit();

       });


       return  binding.getRoot();
    }
}