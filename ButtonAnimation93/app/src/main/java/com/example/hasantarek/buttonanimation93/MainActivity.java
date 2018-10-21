package com.example.hasantarek.buttonanimation93;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab,fb,twt;
    Animation fabOpen,fabClose,fabRotate,fabRotateanti;
    boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = (FloatingActionButton)findViewById(R.id.fab_btn);
        fb = (FloatingActionButton)findViewById(R.id.fab_btn_fb);
        twt = (FloatingActionButton)findViewById(R.id.fab_btn_twt);
        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRotateanti = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotae_anticlockwise);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {

                    fb.startAnimation(fabClose);
                    twt.startAnimation(fabClose);
                    fab.startAnimation(fabRotateanti);
                    fb.setClickable(false);
                    twt.setClickable(false);
                    isOpen = false;


                } else {
                    fb.startAnimation(fabOpen);
                    twt.startAnimation(fabOpen);
                    fab.startAnimation(fabRotate);
                    fb.setClickable(true);
                    twt.setClickable(true);
                    isOpen = true;
            }
            }
        });

    }
}
