package com.example.hasantarek.swip_view_70;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Hasan Tarek on 7/23/2017.
 */
public class Swipadapter extends FragmentStatePagerAdapter{
    public Swipadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count",i+1);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public int getCount() {
        return 5;
    }
}
