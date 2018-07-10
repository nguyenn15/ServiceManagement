package com.example.a300273215.admin;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ORM.RequestOrder;
import Service.FactoryServiceAPI;
import Service.RequestOrderApi;
import adapter.MyAdapter;
import adapter.Tab1RecyclerAdapter;
import model.ListItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 300272368 on 7/7/2018.
 */

public class TabFragment1 extends Fragment {


    List<RequestOrder> orders = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    View view;

     public TabFragment1()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        //addOrders();
        setRecyclerView(view);
        return view;

    }


    public void addOrders(List<RequestOrder> orders) {
       this.orders = orders;

    }

    public void setRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();

        try {
            RequestOrderApi requestorderApi = FactoryServiceAPI.GetRequesetOrderApi();
            Call<List<RequestOrder>> requestorders = requestorderApi.RequestOrders();
            requestorders.enqueue(new Callback<List<RequestOrder>>() {
                @Override
                public void onResponse(Call<List<RequestOrder>> call, Response<List<RequestOrder>> response) {
                    List<RequestOrder> requestOrders = response.body();
                    /// add to list here
                    //Toast.makeText(AdminHomePage.this, "request Order" + requestOrders.get(0), Toast.LENGTH_SHORT).show();
                  //  SetDataSourceFragment1(requestOrders);



                    for (RequestOrder tp : requestOrders) {
                        Log.i("data",tp.getIdRequest()+"");
                        ListItem listItem = new ListItem("Request Number " + tp.getIdRequest() + "", tp.getStatus().toString());
                        listItems.add(listItem);
                    }

                }

                @Override
                public void onFailure(Call<List<RequestOrder>> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }



        for (RequestOrder tp : orders) {
            ListItem listItem = new ListItem("Request Number " + tp.getIdRequest() + "", tp.getStatus().toString());
            listItems.add(listItem);
        }

        adapter = new Tab1RecyclerAdapter(getActivity(), listItems);
        recyclerView.setAdapter(adapter);
    }

}
