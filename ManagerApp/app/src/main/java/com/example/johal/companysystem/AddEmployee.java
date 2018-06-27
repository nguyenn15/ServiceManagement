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
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddEmployee extends AppCompatActivity {
    private Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;

    EditText fn,ln,sin,email,password,position;
    Button add;


    List<Employee> employeeList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        fn=(EditText)findViewById(R.id.firstNameEditText);
        ln=(EditText)findViewById(R.id.latNameEditText);
        sin=(EditText)findViewById(R.id.sinEditText);
        email=(EditText)findViewById(R.id.userIdEditText);
        password=(EditText)findViewById(R.id.passwordEditText);
        position=(EditText)findViewById(R.id.positionEditText);
        add=(Button)findViewById(R.id.addEmployee);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmployee();
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
                        startActivity(new Intent(AddEmployee.this, managerHomePage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AddEmployee.this, EditProfile.class));
                        break;
                    case R.id.assignjob:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AddEmployee.this, AssignJob.class));
                        break;
                    case R.id.addEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AddEmployee.this, AddEmployee.class));
                        break;
                    case R.id.editEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AddEmployee.this, EditEmployee.class));
                        break;
                    case R.id.jobsCompleted:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AddEmployee.this, CompletedJobs.class));
                        break;
                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(AddEmployee.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });

    }
        public void addEmployee()
    {
        int id=1;

        employeeList.add(new Employee(id,fn.getText().toString(),ln.getText().toString()
                ,Integer.parseInt(sin.getText().toString())
                ,email.getText().toString(),password.getText().toString(),position.getText().toString()));

    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Add Employee");
    }


    }

