package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.editText.findViewById(R.id.editText);
        binding.mainButton.findViewById(R.id.main_button);
        binding.mainButton.setOnClickListener(v->sendMessage());

    }

    public void sendMessage() {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = binding.editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}