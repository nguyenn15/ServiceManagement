package com.example.amandeep.customerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class CustomerPage extends AppCompatActivity {
    private Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;
    Button request;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
        request=(Button)findViewById(R.id.reqBtn);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomerPage.this,orderDetailsActivity.class));
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setupToolbarMenu();

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle
                (this, drawerLayout, mToolbar, R.string.drawerOpen, R.string.drawerClose);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigation = (NavigationView) findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.home:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(CustomerPage.this, CustomerPage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(CustomerPage.this, EditProfile.class));
                        break;

                    case R.id.orders:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(CustomerPage.this, OrdersActivity.class));
                        break;


                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(CustomerPage.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });



    }


    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Service");
    }


    }

