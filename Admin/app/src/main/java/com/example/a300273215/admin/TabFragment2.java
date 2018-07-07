package com.example.a300273215.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import model.ListItem;

/**
 * Created by 300272368 on 7/7/2018.
 */

public class TabFragment2 extends Fragment {


    List<Order> orders=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.tab_fragment_2, container, false);


        addOrders();
        setRecyclerView(view);


        return view;

    }


    public void addOrders()
    {
        int id=1;
        orders.add(new Order(id,"first","Send to Manager"));
        orders.add(new Order(id+1,"second","Send to Manager"));
        orders.add(new Order(id+2,"third","Send to Manager"));
        orders.add(new Order(id+3,"fourth","Send to Manager"));
        orders.add(new Order(id+4,"fifth","Send to Manager"));


    }

    public void setRecyclerView(View view)
    {
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems=new ArrayList<>();

        for(Order tp : orders){
            ListItem listItem=new ListItem("Request Number "+ tp.getId()+"",tp.getStatus().toString());
            listItems.add(listItem);
        }

        adapter=new MyAdapter(getActivity(),listItems);
        recyclerView.setAdapter(adapter);
    }

}
