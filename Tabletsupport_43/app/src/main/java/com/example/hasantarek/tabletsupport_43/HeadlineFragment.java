package com.example.hasantarek.tabletsupport_43;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Hasan Tarek on 7/16/2017.
 */
public class HeadlineFragment extends Fragment {
    ListView listView;
    ArrayAdapter<String>adapter;
    String headlines[];
    onHeadlineClick onHeadlineClick;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.headline_fragment,container,false);
        listView = (ListView)view.findViewById(R.id.list_headline);
        headlines = getResources().getStringArray(R.array.news_titles);
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.headline_list,R.id.row_item,headlines);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String headline = headlines[position];
                onHeadlineClick.headlineselect(headline);
            }
        });
        return view;
    }

    public interface onHeadlineClick{
        public void headlineselect(String headline);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            onHeadlineClick = (onHeadlineClick)activity;
        }catch (Exception ex)
        {

        }

    }
}
