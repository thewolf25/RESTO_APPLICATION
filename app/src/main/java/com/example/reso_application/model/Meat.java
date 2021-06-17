package com.example.reso_application.model;


import java.io.Serializable;
import java.util.List;

public class Meat implements Serializable {
    public String name;
    public String type;
    public List<String> gredient;
    public double price;
    public List<String> images;

    public Meat() {
    }


    public Meat(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Meat(String name, List<String> gredient, double price) {
        this.name = name;
        this.gredient = gredient;
        this.price = price;
    }


    public String getIngredientText(){
        String s="" ;
        for (int i=0;i < gredient.size() ;i++){
            s = s + gredient.get(i)+ "\n";
        }
        return  s;
    }
}

