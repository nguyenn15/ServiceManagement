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
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import ORM.RequestOrder;
import ORM.User;
import Service.FactoryServiceAPI;
import Service.RequestOrderApi;
import Service.UserApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class orderDetailsActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;
    EditText area,noOfDoors,entrtExit,openWin,openArea,doorBells,address;
    Button request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        area=(EditText)findViewById(R.id.areaEdit) ;
        noOfDoors=(EditText)findViewById(R.id.doorsEdit) ;
        entrtExit=(EditText)findViewById(R.id.entry_exit_edit) ;
        openArea=(EditText)findViewById(R.id.open_areas_edit) ;
        openWin=(EditText)findViewById(R.id.windowsEdit) ;
        doorBells=(EditText)findViewById(R.id.doorBellsEdit) ;
        address=(EditText)findViewById(R.id.addressEdit) ;
        request=(Button)findViewById(R.id.sendRequest);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setupToolbarMenu();

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle
                (this, drawerLayout, mToolbar, R.string.drawerOpen, R.string.drawerClose);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

       request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });


        navigation = (NavigationView) findViewById(R.id.nav_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.home:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(orderDetailsActivity.this, CustomerPage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(orderDetailsActivity.this, EditProfile.class));
                        break;

                    case R.id.orders:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(orderDetailsActivity.this, OrdersActivity.class));
                        break;


                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(orderDetailsActivity.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });



    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Request Service");
    }

    // send a request to web service
    public void sendRequest()
    {
        if( !area.getText().toString().equals("")||
                !noOfDoors.getText().toString().equals("")||
                !entrtExit.getText().toString().equals("")||
                !openArea.getText().toString().equals("")||
               !openWin.getText().toString().equals("")||
                !address.getText().toString().equals("")||
                !doorBells.getText().toString().equals(""))
        {
            double areaV=Double.parseDouble(area.getText().toString());
            int doorsV=Integer.parseInt(noOfDoors.getText().toString());
            int entryExitV=Integer.parseInt(entrtExit.getText().toString());
            int openWindowsV=Integer.parseInt(openWin.getText().toString());
            int openAreaV=Integer.parseInt(openArea.getText().toString());
            int doorBellsV=Integer.parseInt(doorBells.getText().toString());
            String addressV= address.getText().toString();

            // create api interface
            RequestOrderApi requestOrderApi = FactoryServiceAPI.GetRequesetOrderApi();
            User currentUser = FactoryServiceAPI.currentUser;
            // prepare params for api call
            Map<String, String> params = new HashMap<String, String>();
            params.put("Area", String.valueOf(areaV));
            params.put("Medium", String.valueOf(0));
            params.put("NoOfDoors", String.valueOf(doorsV));
            params.put("EntryDoors", String.valueOf(entryExitV));
            params.put("OpenWindows",String.valueOf(openWindowsV) );
            params.put("OpenAreas", String.valueOf(openAreaV));
            params.put("DoorBell", String.valueOf(doorBellsV));
            params.put("LocationOfService", addressV);
            params.put("idCustomer", currentUser.getId().toString());


            try {
                RequestOrderApi requestOrderApi1 = FactoryServiceAPI.GetRequesetOrderApi();
                Call<RequestOrder> requestOrder = requestOrderApi1.Create(params);

                requestOrder.enqueue(new Callback<RequestOrder>() {
                    @Override
                    public void onResponse(Call<RequestOrder> call, Response<RequestOrder> response) {
                        RequestOrder requestOrder = response.body(); // ok webservice send back the created request order
                        if(requestOrder==null)
                        {
                            Toast.makeText(orderDetailsActivity.this,"Cannot create the Request Order",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(orderDetailsActivity.this,"Create a Request Order with id: "+ requestOrder.getIdRequest(),Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<RequestOrder> call, Throwable t) {

                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        else
        {

        }

    }


}
