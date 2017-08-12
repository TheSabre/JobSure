package com.example.jobsure;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class work extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        ImageView slideImg=(ImageView)findViewById(R.id.workImg) ;

        AnimationDrawable a = new AnimationDrawable();

        a.addFrame(getResources().getDrawable(R.drawable.work),4000);
        a.addFrame(getResources().getDrawable(R.drawable.volunteer),4000);
        a.addFrame(getResources().getDrawable(R.drawable.work),4000);
        a.setEnterFadeDuration(2000);
        a.setExitFadeDuration(2000);
        a.setOneShot(false);

        slideImg.setBackground(a);

        a.start();
    }
    public void goClean(View v)
    {
        Intent i = new Intent(this,cleaning_jobs.class);
        startActivity(i);
    }
}
