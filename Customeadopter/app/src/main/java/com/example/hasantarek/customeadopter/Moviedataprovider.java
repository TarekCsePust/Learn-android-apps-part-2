package com.example.hasantarek.customeadopter;

/**
 * Created by Hasan Tarek on 6/14/2017.
 */
public class Moviedataprovider {

    private int image;
    private String movie;
    private String rating;


    public Moviedataprovider(int image,String movie,String rating) {
        this.image = image;
        this.movie = movie;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
