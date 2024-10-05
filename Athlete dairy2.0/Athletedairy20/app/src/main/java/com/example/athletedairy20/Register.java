package com.example.athletedairy20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText username, password, name, lastname, phone, email;
    private Button registerButton, returnToLoginButton;  // Add the new button
    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        lastname = findViewById(R.id.lastname);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        registerButton = findViewById(R.id.registerbutton);
        returnToLoginButton = findViewById(R.id.returnbutton);  // Initialize the new button
        userInfo = new UserInfo(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String fullName = name.getText().toString().trim() + " " + lastname.getText().toString().trim();
                String userPhone = phone.getText().toString().trim();
                String userEmail = email.getText().toString().trim();

                if (user.equals("") || pass.equals("") || fullName.equals("") || userPhone.equals("") || userEmail.equals("")) {
                    Toast.makeText(Register.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                } else {
                    boolean userExists = userInfo.checkUsernamePassword(user, pass);

                    if (!userExists) {
                        boolean insert = userInfo.insertUserData(user, pass, fullName, userPhone, userEmail);

                        if (insert) {
                            Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), homePage.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(Register.this, "User already exists", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        returnToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToLogin();
            }
        });
    }

    private void returnToLogin() {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
        finish(); // Optional: Close the Register activity if you don't want to go back to it
    }
}
