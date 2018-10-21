package com.example.hasantarek.customeadopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Hasan Tarek on 6/14/2017.
 */
public class Movieadpter extends ArrayAdapter {
    List list = new ArrayList();
    public Movieadpter(Context context, int resource) {
        super(context, resource);
    }

    static class handler
    {
        ImageView poster;
        TextView movie_name;
        TextView movie_rating;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        handler datahandaler;
        datahandaler = new handler();
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_custom,parent,false);

            datahandaler.poster = (ImageView) row.findViewById(R.id.image);
            datahandaler.movie_name = (TextView) row.findViewById(R.id.moviename);
            datahandaler.movie_rating = (TextView) row.findViewById(R.id.rating);
            row.setTag(datahandaler);

        }
        else
        {
            datahandaler = (handler) row.getTag();
        }
        Moviedataprovider moviedataprovider;
        moviedataprovider = (Moviedataprovider) this.getItem(position);
        datahandaler.poster.setImageResource(moviedataprovider.getImage());
        datahandaler.movie_name.setText(moviedataprovider.getMovie());
        datahandaler.movie_rating.setText(moviedataprovider.getRating());

        return row;
    }
}
