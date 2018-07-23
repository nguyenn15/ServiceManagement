package com.example.a300273215.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class SendQuoteToCustomer extends AppCompatActivity {
private EditText noOfAlarmPanel;
    private EditText motionDetector;
    private EditText doorBell;
    private EditText cabelBundle;
    private EditText totalCost;
    private Button sendQuote;
    private int alarmPanels;
    private int detectors;
    private int doorbells;
    private int cablebundles;
    private double totalcost;

    //for updating request order
    private double area;
    private double noOfDoors;
    private double entryDoors;
    private double openWindows;
    private double openAreas;
    private double doorbell;
    private String locationOfService;
    private double status;
    private double idCustomer;
    private double idManager;
    private double idAdmin;
    private int customerID;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_quote_to_customer);
        noOfAlarmPanel=(EditText)findViewById(R.id.noOfAlarmPanel);
        motionDetector=(EditText)findViewById(R.id.motionDetector);
        doorBell=(EditText)findViewById(R.id.doorBell);
        cabelBundle=(EditText)findViewById(R.id.cableBundle);
        totalCost=(EditText)findViewById(R.id.totalCost);
        sendQuote=(Button)findViewById(R.id.sendQuote);
        sendQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                         sendResponse();
            }
        });



    }

    private void sendResponse() {
        if (!noOfAlarmPanel.getText().toString().equals("") &&
                !motionDetector.getText().toString().equals("") &&
                !doorBell.getText().toString().equals("") &&
                !cabelBundle.getText().toString().equals("") &&
                !totalCost.getText().toString().equals("")
                ) {
            alarmPanels = Integer.parseInt(noOfAlarmPanel.getText().toString());
            detectors = Integer.parseInt(motionDetector.getText().toString());
            doorbells = Integer.parseInt(doorBell.getText().toString());
            cablebundles = Integer.parseInt(cabelBundle.getText().toString());
            totalcost = Double.parseDouble(totalCost.getText().toString());

            Intent intent=getIntent();
            int RequestId=intent.getIntExtra("id",0);
            customerID=intent.getIntExtra("idCustomer",0);

            // prepare params for api call
            Map<String, String> params = new HashMap<String, String>();
            params.put("idRequest", RequestId+"");
            params.put("NoOfAlarm", String.valueOf(alarmPanels));
            params.put("MotionDetector", String.valueOf(detectors));
            params.put("CableBundle",String.valueOf(cablebundles) );
            params.put("DoorBell", String.valueOf(doorbells));
            params.put("TotalCost", String.valueOf(totalcost));



            try {

                RequestResponseApi requestResponseApi = FactoryServiceAPI.GetRequestResponseApi();
                Call<RequestResponse> requestResponse = requestResponseApi.Create(params);



                requestResponse.enqueue(new Callback<RequestResponse>() {
                    @Override
                    public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                        RequestResponse responseDone = response.body(); // ok webservice send back the created request order
                        if(responseDone==null)
                        {
                            Log.e("errorrrrrrr",response.errorBody()+"");
                            Log.e("errorrrrrrr",call.request()+"");
                            Toast.makeText(SendQuoteToCustomer.this,"Cannot create the Quote ",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(SendQuoteToCustomer.this,"Created a Request Order with id: "+ responseDone.getIdRequest(),Toast.LENGTH_SHORT).show();
                        noOfAlarmPanel.setText("");
                        motionDetector.setText("");
                        doorBell.setText("");
                        cabelBundle.setText("");
                        totalCost.setText("");


                    }

                    @Override
                    public void onFailure(Call<RequestResponse> call, Throwable t) {

                    }
                });


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


                    }

                    @Override
                    public void onFailure(Call<RequestOrder> call, Throwable t) {

                    }
                });

           /*     User currentUser = FactoryServiceAPI.currentUser;
                Map<String, String> paramUpdate = new HashMap<String, String>();
                paramUpdate.put("idRequest", RequestId+"");
                paramUpdate.put("Area", area+"");
                paramUpdate.put("NoOfDoors", noOfDoors+"");
                paramUpdate.put("EntryDoors", entryDoors+"");
                paramUpdate.put("OpenWindows", openWindows+"");
                paramUpdate.put("OpenAreas", openAreas+"");
                paramUpdate.put("DoorBell", doorbell+"");
                paramUpdate.put("LocationOfService", locationOfService);
                paramUpdate.put("Status", 1+"");
                paramUpdate.put("idCustomer",idCustomer +"");
                paramUpdate.put("idManager", idManager+"");
                paramUpdate.put("idAdmin",+currentUser.getId()+"");

                Call<RequestOrder> requestorderUpdate = requestorderApi.Update(param);
                requestorderUpdate.enqueue(new Callback<RequestOrder>() {
                    @Override
                    public void onResponse(Call<RequestOrder> call, Response<RequestOrder> response) {
                            RequestOrder requestOrder=response.body();
                        if(requestOrder==null)
                        {
                            Toast.makeText(SendQuoteToCustomer.this,"Cannot update the status of Request Order",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(SendQuoteToCustomer.this,"Updated the status of Request Order with id: "+ requestOrder.getIdRequest(),Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<RequestOrder> call, Throwable t) {

                    }
                });*/


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        else
        {
            Toast.makeText(SendQuoteToCustomer.this,"Fill all fields!",Toast.LENGTH_SHORT).show();
        }

    }

}


