package com.example.amandeep.customerapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.ListItem;
import ORM.RequestOrder;
import ORM.RequestResponse;
import ORM.User;
import Service.FactoryServiceAPI;
import Service.RequestOrderApi;
import Service.RequestResponseApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcceptOrderActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;
    private Button btnReject;

    //for updating request order
    private double area;
    private int noOfDoors;
    private int entryDoors;
    private int openWindows;
    private double openAreas;
    private int doorbell;
    private String locationOfService;

    private int idCustomer;
    private int idManager;
    private int idAdmin;
    private int RequestId;

    //private RequestResponse quotes;; //quote details

    TextView quote;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_order);
        Intent intent=getIntent();
        btnReject=(Button)findViewById(R.id.rejectOrder);
         RequestId=intent.getIntExtra("requestId",0);

        quote=(TextView)findViewById(R.id.details);
        send=(Button)findViewById(R.id.sendOrder);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send.setEnabled(false);
                btnReject.setEnabled(false);
// here status of request is changed to accepted
               updateStatus(RequestOrder.STATUS.ACCEPTED.getValue()+"");
            }
        });

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send.setEnabled(false);
                btnReject.setEnabled(false);
                updateStatus(RequestOrder.STATUS.REJECTED.getValue()+"");
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
                         setData();

    }

    private void updateDetails(final String status)
    {
        User currentUser = FactoryServiceAPI.currentUser;
        Map<String, String> paramUpdate = new HashMap<String, String>();
        paramUpdate.put("idRequest", RequestId+"");
        paramUpdate.put("Area", area+"");
        paramUpdate.put("NoOfDoors", noOfDoors+"");
        paramUpdate.put("EntryDoors", entryDoors+"");
        paramUpdate.put("OpenWindows", openWindows+"");
        paramUpdate.put("OpenAreas", openAreas+"");
        paramUpdate.put("DoorBell", doorbell+"");
        paramUpdate.put("LocationOfService", locationOfService+"");
        paramUpdate.put("Status", status);
        paramUpdate.put("idCustomer",idCustomer +"");
        paramUpdate.put("idManager", idManager+"");
        paramUpdate.put("idAdmin",+idAdmin+"");

        RequestOrderApi requestorderApi = FactoryServiceAPI.GetRequesetOrderApi();
        Call<RequestOrder> requestorderUpdate = requestorderApi.Update(paramUpdate);
        requestorderUpdate.enqueue(new Callback<RequestOrder>() {
            @Override
            public void onResponse(Call<RequestOrder> call, Response<RequestOrder> response) {
                RequestOrder requestOrder=response.body();
                if(requestOrder==null)
                {
                    Toast.makeText(AcceptOrderActivity.this,"Cannot update the status of Request Order",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(AcceptOrderActivity.this,"You " + RequestOrder.STATUS.FromInt(Integer.parseInt(status)) +" Order number " + requestOrder.getIdRequest(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AcceptOrderActivity.this,OrdersActivity.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<RequestOrder> call, Throwable t) {
                Log.i("Failure",call.request()+"");

            }
        });
    }


    private void updateStatus(final String status) {

        RequestOrderApi requestorderApi = FactoryServiceAPI.GetRequesetOrderApi();
        Map<String, String> param = new HashMap<String, String>();
        param.put("idRequest", RequestId+"");
        Call<RequestOrder> requestordersById = requestorderApi.RequestOrdersById(param);

        requestordersById.enqueue(new Callback<RequestOrder>() {
            @Override
            public void onResponse(Call<RequestOrder> call, Response<RequestOrder> response) {
                RequestOrder requestOrder= response.body();
                area=  requestOrder.getArea();
                noOfDoors=requestOrder.getNoOfDoors();
                entryDoors=requestOrder.getEntryExitDoors();
                openWindows=requestOrder.getOpenWindows();
                openAreas=requestOrder.getOpenAreas();
                doorbell=requestOrder.getDoorBell();
                locationOfService=requestOrder.getLocationOfService();
                idCustomer=requestOrder.getIdCustomer();
                idManager=requestOrder.getIdManager();
                idAdmin=requestOrder.getIdAdmin();

                updateDetails(status);


            }

            @Override
            public void onFailure(Call<RequestOrder> call, Throwable t) {
                Log.i("Failure",call.request()+"");
            }
        });




    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Orders");


    }

    public void setData()
    {


        Map<String, String> params = new HashMap<String, String>();
        params.put("idRequest", RequestId+"");
        RequestResponseApi requestResponseApi = FactoryServiceAPI.GetRequestResponseApi();
        final Call< List<RequestResponse> > requestResponse = requestResponseApi.getQuoteById(params);

        requestResponse.enqueue(new Callback<List<RequestResponse>>() {
            @Override
            public void onResponse(Call<List<RequestResponse>> call, Response<List<RequestResponse>> response) {
                if(response==null)
                {
                    Log.i("Null",call.request()+"");
                }
                else
                {
                    List<RequestResponse> lst = response.body();
                    RequestResponse objQuote = lst.get(0);

                    quote.setText("Number of Alarms needed: " + objQuote.getNoOfAlarmPanel() +"\n" +
                            "Number of Motion Detectors needed: " + objQuote.getMotionDetector() +"\n" +
                            "Number of doorbells needed: " + objQuote.getDoorBell() + "\n" +
                            "Number of Cable Bundles needed: " + objQuote.getCableBundle() + "\n" +
                            "Total Cost: " + objQuote.getTotalCost());

                }

            }

            @Override
            public void onFailure(Call<List<RequestResponse>> call, Throwable t) {

            }
        });

    }
}
