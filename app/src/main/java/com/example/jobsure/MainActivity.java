package com.example.jobsure;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity{

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);

	        final ImageView logo = (ImageView)findViewById(R.id.splashlogo);
		 	final ImageView circle = (ImageView)findViewById(R.id.thecircle);
	        final TextView tv = (TextView)findViewById(R.id.jobsure_splash);
	        final Animation a = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
	        final Animation a1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);
	        final Animation a2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fadein);

	        Typeface customfont = Typeface.createFromAsset(getAssets(), "Fonts/Trendex.ttf");
	        tv.setTypeface(customfont);

		 	circle.startAnimation(a);

	        a.setAnimationListener(
	                new Animation.AnimationListener() {
	                    @Override
	                    public void onAnimationStart(Animation animation) {
							tv.startAnimation(a2);
							logo.startAnimation(a2);
							a2.setAnimationListener(
									new Animation.AnimationListener() {
										@Override
										public void onAnimationStart(Animation animation) {
											tv.setVisibility(View.VISIBLE);
											logo.setVisibility(View.VISIBLE);
										}

										@Override
										public void onAnimationEnd(Animation animation) {

										}

										@Override
										public void onAnimationRepeat(Animation animation) {

										}
									}
							);
	                    }

	                    @Override
	                    public void onAnimationEnd(Animation animation) {
	                        finish();
	                        changeActivity();
	                    }

	                    @Override
	                    public void onAnimationRepeat(Animation animation) {

	                    }
	                }
	        );

	    }

	    private void changeActivity() {
	        Intent i = new Intent(this,Screen1.class);
	        startActivity(i);
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.menu_main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();

	        //noinspection SimplifiableIfStatement
	        if (id == R.id.action_settings) {
	            return true;
	        }

	        return super.onOptionsItemSelected(item);
	    }
}
