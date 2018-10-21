package com.example.hasantarek.tablayout78;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 8/2/2017.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment>fragments = new ArrayList<>();
    ArrayList<String>tabtitles = new ArrayList<>();

    public void add(Fragment fr,String title)
    {
        fragments.add(fr);
        tabtitles.add(title);
    }
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }
}
