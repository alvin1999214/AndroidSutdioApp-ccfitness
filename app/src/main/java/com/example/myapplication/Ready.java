package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class Ready extends AppCompatActivity {
    private TextView countdownText;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 6000;
    String spart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);

        countdownText = findViewById(R.id.countdown_text);

        Bundle extras = getIntent().getExtras();
        spart = extras.getString("part");

        startTimer();
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                pass();
            }
        }.start();
    }

    private void pass() {
        Intent intent;
        switch (spart) {
            case "Abdomen":
                intent = new Intent(this, JJTraining.class);
                startActivity(intent);
                break;
            case "Chest":
                intent = new Intent(this, JJTrainingC.class);
                startActivity(intent);
                break;
            case "Arm":
                intent = new Intent(this, TDTraining.class);
                startActivity(intent);
                break;
            case "Leg":
                intent = new Intent(this, SquatsTraining.class);
                startActivity(intent);
                break;
        }
    }

    public void updateTimer() {
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds<10) timeLeftText +="0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        countDownTimer.cancel();

        super.onBackPressed();
    }
}
