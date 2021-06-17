package com.example.reso_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.reso_application.model.Meat;
import com.example.reso_application.repository.MeatRepository;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerplat;
    private RecyclerView recyclerpizza;
    private RecyclerView recyclercrepe;
    private MeatAdapter meatAdapter;
    private MeatAdapter meatAdapter1;
    private MeatAdapter meatAdapter2;
    private VideoView mVideoView;
    private List<Meat> MeatDataList = new ArrayList<>();
    private List<Meat> pizzaList = new ArrayList<>();
    private final String VIDEO_SAMPLE = "https://www.youtube.com/watch?v=cWNogNLIiT0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        MeatDataPrepare();
//        mVideoView = findViewById(R.id.videoView);
//        Uri videoUri = Uri.parse(VIDEO_SAMPLE);
//        mVideoView.setVideoURI(videoUri);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
// Set video link (mp4 format )


        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(video);
        videoView.start();

        recyclerplat = findViewById(R.id.recycler_view);
        recyclerpizza = findViewById(R.id.recycler_view1);
        recyclercrepe = findViewById(R.id.recycler_view2);
        meatAdapter = new MeatAdapter(pizzaList,MainActivity.this);
        meatAdapter1 = new MeatAdapter(MeatDataList,MainActivity.this);
        meatAdapter2 = new MeatAdapter(MeatDataList,MainActivity.this);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);

        recyclerplat.setLayoutManager(manager);
        recyclerplat.setAdapter(meatAdapter);

        recyclercrepe.setLayoutManager(manager1);
        recyclercrepe.setAdapter(meatAdapter1);

        recyclerpizza.setLayoutManager(manager2);
        recyclerpizza.setAdapter(meatAdapter2);
        // Write a message to the database
        MeatRepository meatRepository = new MeatRepository();
        meatRepository.findMeat("Pizza","neptune",pizzaList,meatAdapter);


    }


    private void MeatDataPrepare() {
        Meat data = new Meat("pizza fromage", 25.000);
        MeatDataList.add(data);
        Meat data1 = new Meat("pizza thon", 30.000);
        MeatDataList.add(data1);
        Meat data2 = new Meat("pizza salami", 20.000);
        MeatDataList.add(data2);



        Collections.sort(MeatDataList, new Comparator() {


            @Override
            public int compare(Object o1, Object o2) {
                return ((Meat)o1).name.compareTo(((Meat)o2).name);
            }
        });
    }


//    public void showProduct(View view,int id){
//        Intent i = new Intent(this,singleMeat.class);
//
//    }


    @Override
    protected void onResume() {
        super.onResume();
//        Meat m = new Meat();
//        m.name = "4saison";
//        m.type = "Pizza";
//        m.price = 30.0;
//        m.gredient = List.of("fromage","thon","sauce Tomate", "olive");
//        MeatRepository meatRepository = new MeatRepository();
//        meatRepository.insertMeat(m);
//        Meat metFounded ;
//        metFounded = meatRepository.findMeat("Pizza","neptune");
//        if(metFounded != null){
//            Toast.makeText(this,String.valueOf(metFounded.price),Toast.LENGTH_LONG).show();
//        }

    }

    public void connect(View v , Bundle b){



        Intent i = new Intent(this, Connection.class);
        i.putExtras(b);
        startActivity(i);
    }

}