package com.example.hasantarek.fragment_39;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Hasan Tarek on 7/15/2017.
 */
public class FragmentOne extends Fragment {

    ListView listView;
    String versions [];
    ArrayAdapter <String>adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one_layout,container,false);
        listView = (ListView)view.findViewById(R.id.list_view);
        versions = getResources().getStringArray(R.array.android_version);
        adapter = new ArrayAdapter<String>(getActivity(),R.layout.list_view_layout,R.id.row_item,versions);
        listView.setAdapter(adapter);
        return view;
    }
}
