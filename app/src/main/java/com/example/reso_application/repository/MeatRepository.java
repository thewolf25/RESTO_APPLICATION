package com.example.reso_application.repository;

import com.example.reso_application.MeatAdapter;
import com.example.reso_application.model.Meat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MeatRepository {
    FirebaseDatabase database;

    public MeatRepository(){
        database = FirebaseDatabase.getInstance();
    }

    public void findAll(){
    }

    public void findMeat(String type, String name, List<Meat> pizzaList, MeatAdapter meatAdapter){
        DatabaseReference userRef = database.getReference();
        ValueEventListener meatListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                for (DataSnapshot s : dataSnapshot.getChildren()){
                    System.out.println(((Meat)s.getValue(Meat.class)).name);
                    pizzaList.add((Meat)s.getValue(Meat.class));
                    meatAdapter.notifyDataSetChanged();

                }

                //System.out.println("hhhhhhhhhhhhh" + pizzaList.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                System.out.println( "********** loadPost:onCancelled");
            }
        };
        userRef.child(type).addValueEventListener(meatListener);
    }


    public void insertMeat(Meat m){
        DatabaseReference userRef = database.getReference();
        userRef.child(m.type).child(m.name).setValue(m);
    }

    public void deleteMeat(Meat m){
        DatabaseReference userRef = database.getReference();
        userRef.child(m.type).child(m.name).removeValue();
    }

}
