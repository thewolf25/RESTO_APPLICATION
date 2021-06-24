package com.example.reso_application;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.reso_application.ui.main.AdminDashFragment;

public class dashboardAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dash_activity);
        insertFragment("UPDATE");

        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertFragment("ADD");
            }
        });

        findViewById(R.id.updateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertFragment("UPDATE");
            }
        });

        findViewById(R.id.deleteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertFragment("DELETE");
            }
        });
    }




    public void insertFragment(String action){
        Fragment fragment = new AdminDashFragment();

        Bundle bundle = new Bundle();
        bundle.putString("action", action);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentLayout, fragment);
        transaction.commit();
    }


//    public void addClick(View v){
//        insertFragment("ADD");
//    }
//
//    public void updateClick(View v){
//        insertFragment("UPDATE");
//    }
//
//    public void deleteClick(View v){
//        insertFragment("DELETE");
//    }


}