package com.example.jobsure;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity{

    private DrawerLayout drawer;
    private ListView list;
    private ActionBarDrawerToggle drawerListener;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");
        //nav drawer
        list = (ListView)findViewById(R.id.navList);
        drawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        myAdapter = new MyAdapter(this);
        list.setAdapter(myAdapter);
       // list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, options));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
                switch(position){
                    case 1:
                        Intent i = new Intent(home.this,volunteer.class);
                        startActivity(i);
                }
            }
        });

        drawerListener = new ActionBarDrawerToggle(this,drawer,R.string.open_nav,R.string.close_nav){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawer.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        final ImageView iwantto = (ImageView)findViewById(R.id.iwanttoText);

        final Animation a = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fadein);

        iwantto.startAnimation(a);
        a.setDuration(2000);
        iwantto.setVisibility(View.VISIBLE);

    }

    public void selectItem(int position) {
        list.setItemChecked(position, true);
        setTitle(myAdapter.options[position]);
    }

    public void setTitle(String title) {
        try {
            getSupportActionBar().setTitle(title);
        }
        catch(Exception e)
        {
            Toast.makeText(this,"Null",Toast.LENGTH_LONG).show();
        }
    }

    public void goWork(View v)
    {
        Intent i = new Intent(this,work.class);
        startActivity(i);
    }

    public void goVolunteer(View v)
    {
        Intent i = new Intent(this,volunteer.class);
        startActivity(i);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerListener.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }
}

class  MyAdapter extends BaseAdapter
{
    private Context context;
    String options[];
    int images[] = {R.drawable.inner_icon,R.drawable.browse_job_icon,R.drawable.post_a_job_icon,R.drawable.job_icon,R.drawable.chats_icon,R.drawable.favourites_icon,R.drawable.help_icon};

    public MyAdapter(Context context){
        options = context.getResources().getStringArray(R.array.navlist);
        this.context = context;
    }

    @Override
    public int getCount() {
        return options.length;
    }

    @Override
    public Object getItem(int position) {
        return options[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_row,parent,false);
        }
        else {
            row = convertView;
        }

        TextView title = (TextView) row.findViewById(R.id.row_text);
        ImageView logo = (ImageView) row.findViewById(R.id.row_logo);

        title.setText(options[position]);
        logo.setImageResource(images[position]);

        return row;
    }
}