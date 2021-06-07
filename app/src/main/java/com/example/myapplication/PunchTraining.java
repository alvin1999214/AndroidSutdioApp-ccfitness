package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class PunchTraining extends AppCompatActivity {

    private TextView countdownText;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 31000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch_training);

        GifImageView imageView1 = findViewById(R.id.imageView1);
        countdownText = findViewById(R.id.countdown_text);

        try{
            GifDrawable gifDrawable1 = new GifDrawable(getResources(), R.drawable.punchgif);
            imageView1.setImageDrawable(gifDrawable1);

        }catch (Exception e){
            e.printStackTrace();
        }

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
        Intent intent = new Intent(this, FinishTraining.class);
        startActivity(intent);
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
        Intent intent = new Intent(this, Arm.class);
        startActivity(intent);

        super.onBackPressed();
    }
}
