package com.example.a300273215.admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ORM.RequestOrder;
import Service.FactoryServiceAPI;
import Service.RequestOrderApi;
import adapter.Tab1RecyclerAdapter;
import model.ListItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 300272368 on 7/7/2018.
 */

public class TabFragment1 extends Fragment {



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_1, container, false);
        setRecyclerView(view);
        return view;

    }


    public void setRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();

        try {
            RequestOrderApi requestorderApi = FactoryServiceAPI.GetRequesetOrderApi();
            Map<String, String> params = new HashMap<String, String>();
            params.put("Status", RequestOrder.STATUS.PENDING.getValue()+"");

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
                        ListItem listItem = new ListItem(tp.getIdRequest(), tp.getStatus().toString(),tp.getIdCustomer());
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


        adapter = new Tab1RecyclerAdapter(getActivity(), listItems);
        recyclerView.setAdapter(adapter);
    }

}
