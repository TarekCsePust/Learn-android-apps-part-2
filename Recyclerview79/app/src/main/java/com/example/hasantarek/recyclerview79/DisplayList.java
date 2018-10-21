package com.example.hasantarek.recyclerview79;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        Backgroundtask backgroundtask = new Backgroundtask();
        backgroundtask.execute();
    }
}
