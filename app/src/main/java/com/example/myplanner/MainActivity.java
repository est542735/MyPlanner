package com.example.myplanner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the continue button in the layout
        Button continueButton = findViewById(R.id.continueButton);

        // Set the click listener for the continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLoginActivity(); // Load the LoginActivity on button click
            }
        });

        // Start the countdown timer
        new CountDownTimer(7000, 1000) { // 7000ms for 7 seconds
            public void onTick(long millisUntilFinished) {
                // No action needed during ticks
            }

            public void onFinish() {
                // Load the LoginActivity when the timer finishes
                loadLoginActivity();
            }
        }.start();
    }

    // Method to load LoginActivity
    private void loadLoginActivity() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Optional: Finish MainActivity to remove it from the back stack
    }
}

