package com.example.amandeep.customerapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AcceptOrderActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;

    TextView quote;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_order);

        quote=(TextView)findViewById(R.id.details);
        send=(Button)findViewById(R.id.sendOrder);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// here status of request is changed to accepted
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setupToolbarMenu();

        String s = getIntent().getStringExtra("accepted request");
        quote.setText(s); //get request details using request id and display in text view


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
                        startActivity(new Intent(AcceptOrderActivity.this, CustomerPage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AcceptOrderActivity.this, EditProfile.class));
                        break;

                    case R.id.orders:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AcceptOrderActivity.this, OrdersActivity.class));
                        break;


                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AcceptOrderActivity.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });


    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Orders");


    }
}
