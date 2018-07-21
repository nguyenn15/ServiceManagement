package com.example.a300273215.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            double areaV = Double.parseDouble(noOfAlarmPanel.getText().toString());
            int doorsV = Integer.parseInt(motionDetector.getText().toString());
            int entryExitV = Integer.parseInt(doorBell.getText().toString());
            int openWindowsV = Integer.parseInt(cabelBundle.getText().toString());
            int openAreaV = Integer.parseInt(totalCost.getText().toString());

            // create api interface
         /*   RequestResponseApi requestResponseApi = FactoryServiceAPI.GetRequestResponseApi();
            RequestOrder requestOrder = FactoryServiceAPI.id;
            // prepare params for api call
            Map<String, String> params = new HashMap<String, String>();
            params.put("idRequest", currentUser.getId().toString());
            params.put("NoOfAlarm", String.valueOf(doorsV));
            params.put("MotionDetector", String.valueOf(entryExitV));
            params.put("CableBundle",String.valueOf(openWindowsV) );
            params.put("DoorBell", String.valueOf(openAreaV));
            params.put("TotalCost", String.valueOf(doorBellsV));
            params.put("Status", addressV);
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
                            Toast.makeText(orderDetailsActivity.this,"Created a Request Order with id: "+ requestOrder.getIdRequest(),Toast.LENGTH_SHORT).show();
                        area.setText("");
                        noOfDoors.setText("");
                        entrtExit.setText("");
                        openWin.setText("");
                        openArea.setText("");
                        doorBells.setText("");
                        doorBells.setText("");
                        address.setText("");






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
            Toast.makeText(orderDetailsActivity.this,"Fill all fields!",Toast.LENGTH_SHORT).show();
        }*/

        }

    }
    }

