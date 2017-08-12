package com.example.jobsure;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Sign_up extends Activity {

	Intent i;
	LinearLayout li_bottom;
	EditText username, emailid, pwd, confirm_pwd;
	Context context = getApplicationContext();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
	}
	
	public void goToHome(View vif) {
        username = (EditText)findViewById(R.id.username);
        emailid = (EditText)findViewById(R.id.email);
        pwd = (EditText)findViewById(R.id.pwd);
        confirm_pwd = (EditText)findViewById(R.id.confirm_pwd);

        //username.getText().toString();

        if((username.getText().toString().contains(" ") || username.getText().toString().length() <5))
        {
            username.setError("Provide proper username !");
        }
        else if(emailid.getText().toString().contains(" ")|| !emailid.getText().toString().contains

("@gmail.com"))
        {
            emailid.setError("Provide ur gmail-id !");
        }
        else if(!pwd.getText().toString().equals(confirm_pwd.getText().toString()))
        {
            confirm_pwd.setError("Passwords don't match !");
        }
        else 
        {
            i = new Intent(this, home.class);
            startActivity(i);
        }
    }

	public void sign_in_button(View vif) {
		li_bottom = (LinearLayout)findViewById(R.id.li_bottom);
		li_bottom.setBackgroundColor(Color.rgb(7, 27, 82));
		i = new Intent(this, Screen1.class);
		startActivity(i);
	}
}
