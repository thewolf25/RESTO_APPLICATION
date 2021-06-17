package com.example.reso_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.reso_application.ui.main.AdminDashFragment;

public class AdminDash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dash_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AdminDashFragment.newInstance())
                    .commitNow();
        }
    }
}