package com.example.jobsure;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class volunteer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        ImageView slideImg=(ImageView)findViewById(R.id.volImg) ;

        AnimationDrawable a = new AnimationDrawable();

        a.addFrame(getResources().getDrawable(R.drawable.planting_trees),3000);
        a.addFrame(getResources().getDrawable(R.drawable.help),3000);
        a.addFrame(getResources().getDrawable(R.drawable.mwabp),3000);
        a.setEnterFadeDuration(2000);
        a.setExitFadeDuration(2000);
        a.setOneShot(false);

        slideImg.setBackground(a);

        a.start();

       }

}
