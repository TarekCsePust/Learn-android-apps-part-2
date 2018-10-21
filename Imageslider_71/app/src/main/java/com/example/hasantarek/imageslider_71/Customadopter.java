package com.example.hasantarek.imageslider_71;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Hasan Tarek on 7/23/2017.
 */
public class Customadopter extends PagerAdapter {

    private int[]images = {R.drawable.img1,
            R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
            R.drawable.img6
    };
    private Context context;
    private LayoutInflater layoutInflater;
    Customadopter(Context context)
    {
        this.context = context;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == (LinearLayout)o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.swiplayout,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView textView = (TextView)view.findViewById(R.id.textView);
        imageView.setImageResource(images[position]);
        textView.setText("This is the " + position + " image");
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((LinearLayout)object);
    }
}
