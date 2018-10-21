package com.example.hasantarek.filterrecycler96;

/**
 * Created by Hasan Tarek on 8/17/2017.
 */
public class Country {

    private String name;
    private int flag_id;

    public Country(String name, int flag_id) {
        this.name = name;
        this.flag_id = flag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag_id() {
        return flag_id;
    }

    public void setFlag_id(int flag_id) {
        this.flag_id = flag_id;
    }
}
