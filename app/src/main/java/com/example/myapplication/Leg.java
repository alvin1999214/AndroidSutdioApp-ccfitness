package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Leg extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GifImageView imageView1 = findViewById(R.id.imageView1);
        GifImageView imageView2 = findViewById(R.id.imageView2);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button start = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        start.setOnClickListener(this);

        try{
            GifDrawable gifDrawable1 = new GifDrawable(getResources(), R.drawable.squatsgif);
            imageView1.setImageDrawable(gifDrawable1);

            GifDrawable gifDrawable2 = new GifDrawable(getResources(), R.drawable.shgif);
            imageView2.setImageDrawable(gifDrawable2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, SquatsPopUp.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, SHPopUp.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(this, Ready.class);
                intent.putExtra("part", "Leg");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);

    }
}
