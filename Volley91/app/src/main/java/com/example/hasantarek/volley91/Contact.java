package com.example.hasantarek.volley91;

/**
 * Created by Hasan Tarek on 8/14/2017.
 */
public class Contact {

    private String name,email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}