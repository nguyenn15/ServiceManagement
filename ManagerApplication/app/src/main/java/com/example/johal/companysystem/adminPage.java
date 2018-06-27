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
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;
 // testing

public class adminPage extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigation;


    List<Order> orders=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);



        navigation = (NavigationView) findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.home:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(adminPage.this, adminPage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(adminPage.this, EditProfile.class));

                        break;
                    case R.id.assignjob:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(adminPage.this, AssignJob.class));
                        break;
                    case R.id.addEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(adminPage.this, AddEmployee.class));
                        break;
                    case R.id.editEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(adminPage.this, EditProfile.class));
                        break;
                    case R.id.jobsCompleted:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(adminPage.this, CompletedJobs.class));
                        break;
                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(adminPage.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });
                addOrders();
                setRecyclerView();




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
                ListItem listItem=new ListItem(tp.getId() + " " + tp.getName()+" "+tp.getStatus()+"\n");
                listItems.add(listItem);
            }

            adapter=new MyAdapter(this,listItems);
            recyclerView.setAdapter(adapter);
        }
    }

