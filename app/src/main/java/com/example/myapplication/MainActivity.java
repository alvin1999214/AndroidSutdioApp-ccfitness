package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    EditText nameid;
    EditText password;
    CheckBox showpw;
    VideoView fitness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.login);
        Button sig= findViewById(R.id.signu);
        Button google=findViewById(R.id.GOOGLE);
        Button facebook=findViewById(R.id.FACEBOOK);
        showpw=findViewById(R.id.showpw);
        fitness=findViewById(R.id.Fitnessbg);
        nameid= findViewById(R.id.nameid);
        password= findViewById(R.id.password);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ft);
        fitness.setVideoURI(uri);
        fitness.start();

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Hmm,This function isn't available now ",    Toast.LENGTH_SHORT).show();

            }
        });




        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Hmm,This function isn't available now ",    Toast.LENGTH_SHORT).show();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {

                                         if(nameid.getText().toString().equals(""))
                                         {
                                             Toast.makeText(getBaseContext(), "You didn't enter the Name",    Toast.LENGTH_SHORT).show();

                                         }
                                         else if(password.getText().toString().equals("")) //height is the name of the Edittext in code
                                         {
                                             Toast.makeText(getBaseContext(), "You didn't enter the Password",    Toast.LENGTH_SHORT).show();

                                         }else if (!(nameid.getText().toString().equals("nelson"))||!(password.getText().toString().equals("workout1234")))
                                         {
                                             Toast.makeText(getBaseContext(), "Hmm,that isn't a vaild account",    Toast.LENGTH_SHORT).show();
                                         } else  openActivity(2);
                                     }

                                 }
        );

        fitness.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
        {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                mp.start();
            }
        });


        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(3);
            }
        });

        showpw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


    }


    public void openActivity(int x ){
        Intent intent;
        switch (x){
            case 2:intent = new Intent(this, Home.class);
                startActivity(intent);break;
            case 3: intent = new Intent(this, signup.class);
                startActivity(intent);break;

        }}
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}