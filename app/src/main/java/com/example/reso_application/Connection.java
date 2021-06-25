package com.example.reso_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Connection extends AppCompatActivity {
    EditText username ;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        findViewById(R.id.handleConnection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(username.getText().toString().equals("nidhal") && password.getText().toString().equals("nidhal")){
                    Intent i = new Intent(getApplicationContext(),dashboardAdmin.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Bad Credientials ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



}