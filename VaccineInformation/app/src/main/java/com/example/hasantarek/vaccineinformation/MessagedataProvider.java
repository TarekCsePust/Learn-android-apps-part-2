package com.example.hasantarek.vaccineinformation;

/**
 * Created by Hasan Tarek on 11/27/2017.
 */
public class MessagedataProvider {

    String text;
    String date;

    public MessagedataProvider(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }
}