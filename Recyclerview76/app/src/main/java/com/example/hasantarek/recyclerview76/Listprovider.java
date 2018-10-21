package com.example.hasantarek.recyclerview76;

/**
 * Created by Hasan Tarek on 7/30/2017.
 */
public class Listprovider {
    int image_id;
    String Lproduction,Lactor;

    public Listprovider(int image_id, String lproduction, String lactor) {
        this.image_id = image_id;
        Lproduction = lproduction;
        Lactor = lactor;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getLproduction() {
        return Lproduction;
    }

    public void setLproduction(String lproduction) {
        Lproduction = lproduction;
    }

    public String getLactor() {
        return Lactor;
    }

    public void setLactor(String lactor) {
        Lactor = lactor;
    }
}
