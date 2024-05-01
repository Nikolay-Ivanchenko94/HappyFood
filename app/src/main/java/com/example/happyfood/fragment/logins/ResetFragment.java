package com.example.happyfood.fragment.logins;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.happyfood.R;
import com.example.happyfood.databinding.FragmentResetBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class ResetFragment extends Fragment {

    private FragmentResetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentResetBinding.inflate(inflater,container,false);


       binding.btnVerify.setOnClickListener(v -> {
           if (binding.evNewPsw.getText().toString().isEmpty() ||
                   binding.evConPsw.getText().toString().isEmpty()) {
               Toast.makeText(getActivity().getApplicationContext(),
                       "Fields is empty", Toast.LENGTH_LONG).show();
           } else {
               HashMap<String,String > userInfo = new HashMap<>();
               userInfo.put("newPsw",binding.evNewPsw.getText().toString());
               userInfo.put("confirmPsw",binding.evConPsw.getText().toString());
               FirebaseDatabase.getInstance().getReference().child("Users").
                       child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                       .setValue(userInfo);
               DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Заміна Пароля");
               ResetFragment2 resetFragment2 = new ResetFragment2();
               getActivity().getSupportFragmentManager().
                       beginTransaction().replace(R.id.container,resetFragment2,
                               "findThisFragment").addToBackStack(null)
                       .commit();
           }
       });
       binding.btnBack.setOnClickListener(v -> {
           ForgotFragment forgotFragment = new ForgotFragment();
           getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,forgotFragment,
                   "findThisFragment")
                   .addToBackStack(null)
                   .commit();
       });

       return  binding.getRoot();
    }
}