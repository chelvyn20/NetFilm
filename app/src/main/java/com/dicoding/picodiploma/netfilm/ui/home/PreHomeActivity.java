package com.dicoding.picodiploma.netfilm.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.picodiploma.netfilm.R;

public class PreHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_home);

        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(PreHomeActivity.this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        }, SPLASH_TIME_OUT);
    }
}