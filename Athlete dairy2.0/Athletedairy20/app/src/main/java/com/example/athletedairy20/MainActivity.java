package com.example.athletedairy20;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.startButton);

        // Set the countdown timer for 30 seconds (30000 milliseconds)
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // This method is called every second during the countdown
            }

            @Override
            public void onFinish() {
                // Start the Login activity when the countdown finishes
                startLogin();
            }
        };

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLogin();
            }
        });

        // Start the countdown timer
        countDownTimer.start();
    }

    private void startLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish(); // Optional: Close the MainActivity if you don't want to go back to it
        // Cancel the countdown timer to avoid leaks
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}

