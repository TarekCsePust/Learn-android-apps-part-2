package com.example.hasantarek.swip_view_70;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends android.support.v4.app.Fragment {

    TextView textView;

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page,container,false);
        textView = (TextView)view.findViewById(R.id.textView);
        Bundle bundle = getArguments();
        String msg = Integer.toString(bundle.getInt("count"));
        textView.setText("This is the" + msg + " no page");
        return view;
    }


}
