package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Abdomen extends AppCompatActivity implements View.OnClickListener {
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abdomen);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GifImageView imageView1 = findViewById(R.id.imageView1);
        GifImageView imageView2 = findViewById(R.id.imageView2);
        GifImageView imageView3 = findViewById(R.id.imageView3);
        GifImageView imageView4 = findViewById(R.id.imageView4);
        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button start = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        start.setOnClickListener(this);

        try{
            GifDrawable gifDrawable1 = new GifDrawable(getResources(), R.drawable.jumpingjacksgif);
            imageView1.setImageDrawable(gifDrawable1);

            GifDrawable gifDrawable2 = new GifDrawable(getResources(), R.drawable.situpgif);
            imageView2.setImageDrawable(gifDrawable2);

            GifDrawable gifDrawable3 = new GifDrawable(getResources(), R.drawable.mcgif);
            imageView3.setImageDrawable(gifDrawable3);

            GifDrawable gifDrawable4 = new GifDrawable(getResources(), R.drawable.plankgif);
            imageView4.setImageDrawable(gifDrawable4);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, JJPopUp.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, SitUpPopUp.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, MCPopUp.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(this, PPopUp.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(this, Ready.class);
                intent.putExtra("part", "Abdomen");
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
