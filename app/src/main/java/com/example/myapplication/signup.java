package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private Button bli;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button su = findViewById(R.id.su);

        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameid= findViewById(R.id.nameid);
                EditText password= findViewById(R.id.password);
                EditText password2= findViewById(R.id.password2);
                if(nameid.getText().toString().equals(""))
                {
                    Toast.makeText(getBaseContext(), "You didn't enter the Name",    Toast.LENGTH_SHORT).show();

                }
                else if(password.getText().toString().equals("")) //height is the name of the Edittext in code
                {
                    Toast.makeText(getBaseContext(), "You didn't enter the Password",    Toast.LENGTH_SHORT).show();

                } else if(password2.getText().toString().equals("")) //height is the name of the Edittext in code
                {
                    Toast.makeText(getBaseContext(), "You didn't confirm the Password", Toast.LENGTH_SHORT).show();
                } else if (!(password.getText().toString().equals(password2.getText().toString()))){
                    Toast.makeText(getBaseContext(), "The password are not the same", Toast.LENGTH_SHORT).show();
                }
                else  Toast.makeText(getBaseContext(), "Hmm,This function isn't available now ", Toast.LENGTH_SHORT).show();
            }

        });
         Button bli = findViewById(R.id.bli);
                bli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(3);
            }

        });


        }


    public void openActivity(int x){
        switch (x) {
           case 2: Intent intent = new Intent(this, Home.class);
                startActivity(intent);break;
            case 3: intent = new Intent(this, MainActivity.class);
                startActivity(intent);break;


        }

    }
}
