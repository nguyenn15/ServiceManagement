package com.example.a300275913.listofjobs;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    DrawerLayout drawerLayout;
    NavigationView navigation;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        setupToolbarMenu();

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.drawerOpen, R.string.drawerClose);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigation = (NavigationView)findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.home:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        break;
                    case R.id.Profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                       // startActivity(new Intent(MainActivity.this, EditProfile.class));

                        break;

                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(MainActivity.this, LoginScreen.class));
                        break;
                }
                return false;
            }
        });

        listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.JobNumber));
        listview.setAdapter(mAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Job_Details.class);
                intent.putExtra("JobNumber", listview.getItemAtPosition(i).toString());
                //  Toast.makeText(MainActivity.this,listview.getItemAtPosition(i).toString() , Toast.LENGTH_SHORT).show();
                //  startActivity(intent);

                Intent mIntent = new Intent(MainActivity.this, Job_Details.class);
                Bundle mBundle = new Bundle();
                mBundle.putString("JobNumber", listview.getItemAtPosition(i).toString());
                mIntent.putExtras(mBundle);
                startActivity(intent);
            }
        });


    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("ORDERS");
    }


}



