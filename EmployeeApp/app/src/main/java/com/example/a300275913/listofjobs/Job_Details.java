package com.example.a300275913.listofjobs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


public class Job_Details extends AppCompatActivity {
    Toolbar mtoolbar;
    TextView details;
    String StrData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job__details);


        mtoolbar = (Toolbar) findViewById(R.id.toolbar2);
        details = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        if (null != intent) { //Null Checking
          StrData = intent.getStringExtra("JobNumber");
        }

        if (StrData != null) {
            mtoolbar.setTitle(StrData);

            if (StrData.equalsIgnoreCase("Job 1")) {
                details.setText("Information of Job 1");}

       if (StrData.equalsIgnoreCase("Job 2")) {
                    details.setText("Information of Job 2");
                }
          if (StrData.equalsIgnoreCase("Job 3")) {
                    details.setText("Information of Job 3");
                }
            if (StrData.equalsIgnoreCase("Job 4")) {
                    details.setText("Information of Job 4");
                }
                if (StrData.equalsIgnoreCase("Job 5")) {
                    details.setText("Information of Job 5");
                }
                if (StrData.equalsIgnoreCase("Job 6")) {
                    details.setText("Information of Job 6");
                }
            }
        }
    }
