package com.example.athletedairy20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    private Button loginButton, registerButton;
    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginbutton);
        registerButton = findViewById(R.id.registerbutton);
        userInfo = new UserInfo(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (user.equals("") || pass.equals("")) {
                    Toast.makeText(Login.this, "Please enter both username and password", Toast.LENGTH_LONG).show();
                } else {
                    boolean isValidUser = userInfo.checkUsernamePassword(user, pass);

                    if (isValidUser) {
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), homePage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });
    }

    public void openRegister() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
