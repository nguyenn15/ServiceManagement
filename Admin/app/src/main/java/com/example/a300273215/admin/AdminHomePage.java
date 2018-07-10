package com.example.a300273215.admin;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import model.ListItem;

public class AdminHomePage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigation;
    private Toolbar mToolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);
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
                        startActivity(new Intent(AdminHomePage.this, AdminHomePage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AdminHomePage.this, EditProfile.class));

                        break;

                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AdminHomePage.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });





        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Requests From Customers"));
        tabLayout.addTab(tabLayout.newTab().setText("Accepted Requests from Customers"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("REQUESTS");
    }

}
