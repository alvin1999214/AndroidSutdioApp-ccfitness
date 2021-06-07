package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SitUp extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit_up);

        GifImageView imageView1 = findViewById(R.id.imageView1);
        Button button = findViewById(R.id.button6);

        button.setOnClickListener(this);

        try{
            GifDrawable gifDrawable1 = new GifDrawable(getResources(), R.drawable.situpgif);
            imageView1.setImageDrawable(gifDrawable1);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Abdomen.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MCTraining.class);
        startActivity(intent);
    }
}
