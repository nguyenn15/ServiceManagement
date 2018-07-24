package com.example.a300273215.admin;

import android.content.Intent;
import android.content.SharedPreferences;
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

import ORM.RequestOrder;
import ORM.RequestResponse;
import ORM.User;
import Service.FactoryServiceAPI;
import Service.RequestOrderApi;
import Service.RequestResponseApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendToManager extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigation;
    private Toolbar mToolbar;

    TextView quote;
    Button send;


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to_manager);

        quote=(TextView)findViewById(R.id.details);
        send=(Button)findViewById(R.id.sendOrder);
        Intent intent=getIntent();
        RequestId=intent.getIntExtra("requestId",0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// here status of request is changed to accepted
                updateStatus();
            }
        });
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
                        startActivity(new Intent(SendToManager.this, AdminHomePage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(SendToManager.this, EditProfile.class));

                        break;

                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        SharedPreferences.Editor editor = getSharedPreferences("login",MODE_PRIVATE).edit();
                        editor.putString("login", "Logout");
                        editor.apply();
                        startActivity(new Intent(SendToManager.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });
        setData();


    }

    private void updateDetails()
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
        paramUpdate.put("Status", RequestOrder.STATUS.INPROGRESS.getValue()+"");
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
                    Toast.makeText(SendToManager.this,"Cannot send Empty Request",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(SendToManager.this,"Order Sent To Manager "+ requestOrder.getIdRequest(),Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onFailure(Call<RequestOrder> call, Throwable t) {
                Log.i("Failure",call.request()+"");

            }
        });
    }


    private void updateStatus() {

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

                updateDetails();


            }

            @Override
            public void onFailure(Call<RequestOrder> call, Throwable t) {
                Log.i("Failure",call.request()+"");
            }
        });




    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Accepted Orders");
    }

    public void setData()
    {


        Map<String, String> params = new HashMap<String, String>();
        params.put("idRequest", RequestId+"");
        RequestResponseApi requestResponseApi = FactoryServiceAPI.GetRequestResponseApi();
        final Call<List<RequestResponse>> requestResponse = requestResponseApi.getQuoteById(params);

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

                    quote.setText("Number of Alarms needed: \n" + objQuote.getNoOfAlarmPanel() +"\n" +
                            "Number of Motion Detectors needed:\n " + objQuote.getMotionDetector() +"\n" +
                            "Number of doorbells needed: \n" + objQuote.getDoorBell() + "\n" +
                            "Number of Cable Bundles needed: \n" + objQuote.getCableBundle() + "\n" +
                            "Total Cost: \n" + objQuote.getTotalCost());

                }

            }

            @Override
            public void onFailure(Call<List<RequestResponse>> call, Throwable t) {

            }
        });

    }
}
