package com.app.graphicsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.graphicsandroid.databinding.ActivityTranstionBinding;

public class TransitionActivity extends AppCompatActivity {
ActivityTranstionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTranstionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}