package com.example.happyfood.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.happyfood.R;
import com.example.happyfood.fragment.onboarding.LogoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment logoFargment = new LogoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,logoFargment).commit();
    }
}