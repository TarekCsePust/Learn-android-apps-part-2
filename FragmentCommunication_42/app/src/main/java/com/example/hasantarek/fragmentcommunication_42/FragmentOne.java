package com.example.hasantarek.fragmentcommunication_42;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Hasan Tarek on 7/15/2017.
 */
public class FragmentOne extends Fragment {

    onNameSet onNameSet;
    EditText editText;
    Button submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentlayoutone,container,false);
        editText = (EditText)view.findViewById(R.id.frOneText);
        submit = (Button)view.findViewById(R.id.submit_id);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                onNameSet.setName(name);
            }
        });
        return  view;

    }



    public interface onNameSet
    {
        public void setName(String name);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onNameSet = (onNameSet) activity;
        }catch (Exception ex)
        {

        }
    }
}
