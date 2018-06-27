package com.example.johal.companysystem;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.ProcessingInstruction;

public class OrderDetails extends AppCompatActivity {
    private Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;
    private TextView orderNumber;
    private Button btnAssign;
    private Spinner empSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        orderNumber=(TextView)findViewById(R.id.order_number);
        btnAssign=(Button)findViewById(R.id.btnAssign);
        empSpinner = (Spinner) findViewById(R.id.empSpinner);

        String[] spinner_item = new String[]{
                "emp1",
                "emp2"
        };


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner,spinner_item);


        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner);
        empSpinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter.notifyDataSetChanged();

        String s = getIntent().getStringExtra("order_number");
        orderNumber.setText(s);
        setupToolbarMenu();

        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle
                (this, drawerLayout, mToolbar, R.string.drawerOpen, R.string.drawerClose);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        btnAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderDetails.this,"Job Assigned",Toast.LENGTH_LONG).show();
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
                        startActivity(new Intent(OrderDetails.this, managerHomePage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrderDetails.this, EditProfile.class));

                        break;
                    case R.id.assignjob:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrderDetails.this, AssignJob.class));
                        break;
                    case R.id.addEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrderDetails.this, AddEmployee.class));
                        break;
                    case R.id.editEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrderDetails.this, EditProfile.class));
                        break;
                    case R.id.jobsCompleted:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrderDetails.this, CompletedJobs.class));
                        break;
                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(OrderDetails.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });
    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Order Details");
    }
}
