package com.example.hasantarek.fragmentcommunication_42;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hasan Tarek on 7/15/2017.
 */
public class FragmentTwo extends Fragment {

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentlayouttwo,container,false);
        textView = (TextView)view.findViewById(R.id.fragTwoText);
        textView.setVisibility(View.GONE);
        return  view;
    }

    public void updateText(String name)
    {
        textView.setText(name);
        textView.setVisibility(View.VISIBLE);
    }
}
