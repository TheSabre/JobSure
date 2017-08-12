package com.example.jobsure;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Screen1 extends Activity {

	RelativeLayout ScrLayout;
	LinearLayout li;
	TextView or, forget, sign_in, knot_text, up_sign_in, show;
	EditText username;
	Button sign_in_button;
	Button google,fb,twitter, submit;
	EditText password; 
	ImageView up_Y;
	 boolean count1, count, count2,flag;
	 Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen1);
		
		count2 = true;
		count = true;
		count1 = true;
		flag = true;
		
        final ImageView logo = (ImageView) findViewById(R.id.logo);

        logo.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
            	if(count2){
            		count2 = false;
            		ScrLayout = (RelativeLayout) findViewById(R.id.ScrLayout);
                    final TransitionDrawable trans = (TransitionDrawable) getResources().getDrawable(R.drawable.transition);
                    trans.startTransition(2000);
                    ScrLayout.setBackground(trans);
            	
            }
            	translate();
            }
        });
        
        
        show = (TextView)findViewById(R.id.show);
		
        show.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//change of show hide image
					
					password = (EditText)findViewById(R.id.pwd);
					
					show = (TextView)findViewById(R.id.show);
			        if(flag) {

			            show.setText("HIDE");
			            password.setInputType(InputType.TYPE_CLASS_TEXT);
			            flag = false;
			        }
			        else{
			            show.setText("SHOW");
			            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			            flag = true;
			        }
				}
			
		});

	}
	
	public void initialize(){
		or = (TextView)findViewById(R.id.or_text);
		forget = (TextView)findViewById(R.id.forget_password);
		password =(EditText)findViewById(R.id.pwd);
		sign_in = (TextView)findViewById(R.id.sign_in_text);
		google = (Button)findViewById(R.id.google);
		fb = (Button)findViewById(R.id.fb);
		twitter = (Button)findViewById(R.id.twitter);
		submit = (Button)findViewById(R.id.submit);
		knot_text = (TextView)findViewById(R.id.knot);
		username = (EditText)findViewById(R.id.username);
		up_sign_in = (TextView)findViewById(R.id.up_sign_in_text);
		password = (EditText)findViewById(R.id.pwd);
		show = (TextView)findViewById(R.id.show);
		li = (LinearLayout)findViewById(R.id.up_blue_linear);
		sign_in_button = (Button)findViewById(R.id.down_sign_in_button);
	}
	
	//constraints to username
	public void submit_button(View vif) {
		username = (EditText)findViewById(R.id.username);
		
		//username.getText().toString();
		
		if(username.getText().toString().contains(" ") || username.getText().toString().length() <5){
			username.setError("Provide proper username");
		}
		
		else{
			i = new Intent(this, home.class);
			startActivity(i);
		}
	}
	
	
	public void translate() {


		final View logo = findViewById(R.id.logo);
        Animation a = AnimationUtils.loadAnimation(getBaseContext(),
                R.anim.rotate_n_fadeout);
  
        
        if(count) {
        	count = false;
            logo.startAnimation(a);
        }



		a.setAnimationListener(
                new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        logo.setVisibility(View.INVISIBLE);
                    }

                 @Override
                    public void onAnimationEnd(Animation animation) {
                	 count1 = true;
                	initialize();
                	
                        Typeface customfont = Typeface.createFromAsset(getAssets(), "Fonts/Trendex.ttf");
                        knot_text.setTypeface(customfont, Typeface.BOLD);

                        if(count1==true) {
                            visibility();
                        }

                        }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                }
        );

	}

	public void visibility()
    {

        final Animation a2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadein);
        
        
        fb.startAnimation(a2);
        fb.setVisibility(View.VISIBLE);
        knot_text.startAnimation(a2);
        knot_text.setVisibility(View.VISIBLE);
        twitter.startAnimation(a2);
        twitter.setVisibility(View.VISIBLE);
        google.startAnimation(a2);
        google.setVisibility(View.VISIBLE);
        sign_in.startAnimation(a2);
        sign_in.setVisibility(View.VISIBLE);
        or.startAnimation(a2);
        or.setVisibility(View.VISIBLE);
        forget.startAnimation(a2);
        forget.setVisibility(View.VISIBLE);
        submit.startAnimation(a2);
        submit.setVisibility(View.VISIBLE);
        show.startAnimation(a2);
        show.setVisibility(View.VISIBLE);
        username.startAnimation(a2);
        username.setVisibility(View.VISIBLE);
        password.startAnimation(a2);
        password.setVisibility(View.VISIBLE);
        up_sign_in.startAnimation(a2);
        up_sign_in.setVisibility(View.VISIBLE);
        sign_in_button.startAnimation(a2);
        sign_in_button.setVisibility(View.VISIBLE);
        li.startAnimation(a2);
        li.setVisibility(View.VISIBLE);
    }

    public void sign_up_button(View view)
    {
        i = new Intent(this,Sign_up.class);
        startActivity(i);
    }
}
