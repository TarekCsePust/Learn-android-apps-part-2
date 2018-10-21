package com.example.hasantarek.fragmentcommunicstion;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by Hasan Tarek on 7/15/2017.
 */
public class FragmentRadio extends Fragment {

    RadioGroup colors;
    onColorchangeListner colorchangeListner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_radio,container,false);
        colors = (RadioGroup)view.findViewById(R.id.color);
        colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId)
                {
                    case R.id.red:
                        colorchangeListner.colorChanged("Red");
                        break;
                    case R.id.green:
                        colorchangeListner.colorChanged("Green");
                        break;
                    case  R.id.blue:
                        colorchangeListner.colorChanged("Blue");
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        colorchangeListner = (onColorchangeListner)activity;

    }

    public interface onColorchangeListner
    {
        public void colorChanged(String color);
    }
}
