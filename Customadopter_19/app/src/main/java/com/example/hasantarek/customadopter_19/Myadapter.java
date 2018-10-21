package com.example.hasantarek.customadopter_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hasan Tarek on 6/14/2017.
 */
public class Myadapter extends ArrayAdapter<String> {
    String[] movies;
    int[] poster;
    Context mcontext;
    public Myadapter(Context context,String[] moviename,int[] images) {
        super(context,R.layout.listviewitem);
        this.movies = moviename;
        this.poster = images;
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Imageholder imageholder = new Imageholder();
        if(convertView == null)
        {
            LayoutInflater minflator = (LayoutInflater)mcontext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = minflator.inflate(R.layout.listviewitem,parent,false);
            imageholder.movieimage = (ImageView) convertView.findViewById(R.id.image);
            imageholder.moviename =(TextView)convertView.findViewById(R.id.movie_name);
            convertView.setTag(imageholder);


        }
        else
        {
            imageholder = (Imageholder) convertView.getTag();
        }

        imageholder.movieimage.setImageResource(poster[position]);
        imageholder.moviename.setText(movies[position]);

        return convertView;
    }

    static class Imageholder
    {
        ImageView movieimage;
        TextView moviename;
    }
}
