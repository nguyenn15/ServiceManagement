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
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    private Toolbar mToolbar;
    DrawerLayout drawerLayout;
    NavigationView navigation;

    EditText fn,ln,sin,email,password,position;
    Button update;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        fn=(EditText)findViewById(R.id.firstNameEditText);
        ln=(EditText)findViewById(R.id.latNameEditText);
        sin=(EditText)findViewById(R.id.sinEditText);
        email=(EditText)findViewById(R.id.userIdEditText);
        password=(EditText)findViewById(R.id.passwordEditText);
        position=(EditText)findViewById(R.id.positionEditText);
        update=(Button)findViewById(R.id.editProfile);

update.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        updateData();
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
                        startActivity(new Intent(EditProfile.this, managerHomePage.class));
                        break;
                    case R.id.profile:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(EditProfile.this, EditProfile.class));
                        break;

                    case R.id.addEmployee:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(EditProfile.this, AddEmployee.class));
                        break;


                    case R.id.logout:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        startActivity(new Intent(EditProfile.this, LoginActivity.class));
                        break;
                }
                return false;
            }
        });

    }
    public void updateData()
    {
        String newFirstname=fn.getText().toString();
        String newLastName=ln.getText().toString();
        String newEmail=email.getText().toString();
        String newPassword= password.getText().toString();
        Toast.makeText(this,"update",Toast.LENGTH_SHORT).show();

    }

    private void setupToolbarMenu() {
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Add Employee");
    }
}
