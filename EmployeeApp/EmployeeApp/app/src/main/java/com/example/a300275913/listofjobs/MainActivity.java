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
    Toolbar toolbar;
    ListView listview;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = (DrawerLayout) findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    Toast.makeText(MainActivity.this, "MyProfile", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.viewjobs) {
                    Toast.makeText(MainActivity.this, "MyProfile", Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.Profile) {
                    Toast.makeText(MainActivity.this, "MyProfile", Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.logout) {
                    Toast.makeText(MainActivity.this, "logout", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });


      toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
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


}



