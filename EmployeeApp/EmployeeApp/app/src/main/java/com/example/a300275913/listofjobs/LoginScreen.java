package com.example.a300275913.listofjobs;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import java.util.HashMap;
        import java.util.Map;

public class LoginScreen extends AppCompatActivity {
    Button login;
    EditText email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        login=(Button)findViewById(R.id.login);
        email=(EditText)findViewById(R.id.userId);
        password=(EditText)findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(); // handle login
            }
        });
    }

    public void Login()
    {
        final String uname = email.getText().toString();
        final String pass = password.getText().toString();



        if (uname.isEmpty() || pass.isEmpty()) {
            Toast.makeText(LoginScreen.this, "Fill Credentials", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            Intent intent = new Intent(LoginScreen.this, MainActivity.class);
            startActivity(intent);
        }

    }
}


