package com.example.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class InfoFragment extends Fragment implements View.OnClickListener{
    private View view;
    EditText name, birthday, he, we, ge, phone;
    TextView bmi;

    @Nullable
    @RequiresApi(api = Build.VERSION_CODES.O)

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.info_fragment, container, false);

        name = view.findViewById(R.id.editText2);
        birthday = view.findViewById(R.id.birthday);
        he = view.findViewById(R.id.He);
        we = view.findViewById(R.id.We);
        ge = view.findViewById(R.id.Ge);
        phone = view.findViewById(R.id.phone);
        bmi = view.findViewById(R.id.bmivalue);



        Button update = view.findViewById(R.id.update);

        update.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String value = "";
        name.setText(name.getText());
        birthday.setText(birthday.getText());
        he.setText(he.getText());
        we.setText(we.getText());
        if ((ge.getText().toString().equals("Male"))||(ge.getText().toString().equals("Female")))
        {
            ge.setText(ge.getText());
        }else {
            Toast.makeText(getActivity(),"Only Male/Female can be fill",Toast.LENGTH_SHORT).show();
        }
        phone.setText(phone.getText());

        float height = Float.parseFloat(he.getText().toString());
        float weight = Float.parseFloat(we.getText().toString());
        float h1=height/100;
        float r= weight/(h1*h1);
        String bmivalue = String.format("%.1f", r);
        if(r < 18.5) {
            value = "(Underweight)";
            bmi.setText(value + " " + bmivalue);
            bmi.setTextColor(Color.YELLOW);
        } else if ((r >= 18.5) && (r <= 24.9)) {
            value = "(Normal)";
            bmi.setText(value + " " + bmivalue);
            bmi.setTextColor(Color.GREEN);
        } else if ((r >= 25.0) && (r <= 29.9)) {
            value = "(Overweight)";
            bmi.setText(value + " " + bmivalue);
            bmi.setTextColor(Color.parseColor("#FFFFE500"));
        } else {
            value = "(Obese)";
            bmi.setText(value + " " + bmivalue);
            bmi.setTextColor(Color.RED);
        }
    }
}
