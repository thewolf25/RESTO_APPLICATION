package com.example.reso_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reso_application.model.Meat;

public class singleMeat extends AppCompatActivity {
    ImageView your_imImageView;
    TextView name;
    TextView priceValue;
    TextView ingredientValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_meat);


        Intent i = getIntent();
        Meat meat = (Meat) i.getSerializableExtra("meat");
        Toast.makeText(this,  meat.name, Toast.LENGTH_SHORT).show();
        name = findViewById(R.id.name);
        priceValue = findViewById(R.id.priceValue);
        ingredientValue = findViewById(R.id.ingredientValue);
        your_imImageView = findViewById(R.id.image);
        String fnm = "logo"; //  this is image file name
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+fnm , null, null);
        your_imImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(),imgId));
        priceValue.setText(String.valueOf(meat.price));
        System.out.println("===******======="+meat.gredient.toString());
        ingredientValue.setText(meat.getIngredientText());

    }
}