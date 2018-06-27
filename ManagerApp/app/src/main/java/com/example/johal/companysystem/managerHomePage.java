package com.example.johal.companysystem;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;


public class managerHomePage extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigation;
    private Toolbar mToolbar;


    List<Order> orders=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home_page);

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
                        startActivity(new Intent(managerHomePage.this, managerHomePage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(managerHomePage.this, EditProfile.class));

                        break;
                    case R.id.assignjob:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(managerHomePage.this, AssignJob.class));
                        break;
                    case R.id.addEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(managerHomePage.this, AddEmployee.class));
                        break;
                    case R.id.editEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(managerHomePage.this, EditProfile.class));
                        break;
                    case R.id.jobsCompleted:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(managerHomePage.this, CompletedJobs.class));
                        break;
                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(managerHomePage.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });
                addOrders();
                setRecyclerView();




    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Manager");
    }

    public void addOrders()
        {
            int id=1;
            orders.add(new Order(id,"first","pending"));
            orders.add(new Order(id+1,"second","approved"));
            orders.add(new Order(id+2,"third","pending"));
            orders.add(new Order(id+3,"fourth","approved"));
            orders.add(new Order(id+4,"fifth","pending"));


        }

        public void setRecyclerView()
        {
            recyclerView=(RecyclerView)findViewById(R.id.recycleView);
            recyclerView.setHasFixedSize(true);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            listItems=new ArrayList<>();

            for(Order tp : orders){
                ListItem listItem=new ListItem("Order Number "+ tp.getId()+"",tp.getStatus().toString());
                listItems.add(listItem);
            }

            adapter=new MyAdapter(this,listItems);
            recyclerView.setAdapter(adapter);
        }
    }

