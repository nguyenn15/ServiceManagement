package com.example.amandeep.customerapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapter.MyAdapter;
import Model.ListItem;
import ORM.RequestOrder;
import Service.FactoryServiceAPI;
import Service.RequestOrderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigation;
    private Toolbar mToolbar;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    List<Order> orders=new ArrayList<>();
// here get requested service and set its name in textview pf adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

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
                        startActivity(new Intent(OrdersActivity.this, CustomerPage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrdersActivity.this, EditProfile.class));
                        break;

                    case R.id.orders:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrdersActivity.this, OrdersActivity.class));
                        break;


                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrdersActivity.this, LoginActivity.class));
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
        mToolbar.setTitle("Orders");
    }

    public void addOrders()
    {
        //TOdO HERE GET Orders from database and add to
        int id=1;
        orders.add(new Order(id,"first","pending"));
        orders.add(new Order(id+1,"second","approved"));



    }

    public void setRecyclerView()
    {
        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listItems=new ArrayList<>();
/*// m just using order for convience but actually get request for particular customer from database and show in text view
        for(Order tp : orders){
            ListItem listItem=new ListItem("Order Number "+ tp.getId()+"",tp.getStatus().toString());
            listItems.add(listItem);
        }*/

        try {
            RequestOrderApi requestorderApi = FactoryServiceAPI.GetRequesetOrderApi();
            Map<String, String> params = new HashMap<String, String>();
            params.put("Status", RequestOrder.STATUS.REVIEWED.getValue()+"");

            Call<List<RequestOrder>> requestorders = requestorderApi.byStatus(params);


            requestorders.enqueue(new Callback<List<RequestOrder>>() {
                @Override
                public void onResponse(Call<List<RequestOrder>> call, Response<List<RequestOrder>> response) {
                    List<RequestOrder> requestOrders = response.body();
                    /// add to list here
                    //Toast.makeText(AdminHomePage.this, "request Order" + requestOrders.get(0), Toast.LENGTH_SHORT).show();
                    //  SetDataSourceFragment1(requestOrders);



                    for (RequestOrder tp : requestOrders) {
                        Log.i("data",tp.getIdRequest()+"");
                        ListItem listItem = new ListItem(tp.getIdRequest(), tp.getStatus().toString());
                        listItems.add(listItem);
                    }
                    adapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<List<RequestOrder>> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


        adapter=new MyAdapter(this,listItems);
        recyclerView.setAdapter(adapter);
    }
}
