package com.example.hasantarek.asyntask102;

/**
 * Created by Hasan Tarek on 8/18/2017.
 */
public class Contact {

    private int id;
    private String name;

    public Contact(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
