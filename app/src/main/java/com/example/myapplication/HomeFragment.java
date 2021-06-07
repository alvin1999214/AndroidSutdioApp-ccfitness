package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        ImageButton abdomenButton = view.findViewById(R.id.abdomenButton);
        ImageButton chestButton = view.findViewById(R.id.chestButton);
        ImageButton armButton = view.findViewById(R.id.armButton);
        ImageButton legButton = view.findViewById(R.id.legButton);


        abdomenButton.setOnClickListener(this);
        chestButton.setOnClickListener(this);
        armButton.setOnClickListener(this);
        legButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.abdomenButton:
                intent = new Intent(getActivity(), Abdomen.class);
                startActivity(intent);
                break;
            case R.id.chestButton:
                intent = new Intent(getActivity(), Chest.class);
                startActivity(intent);
                break;
            case R.id.armButton:
                intent = new Intent(getActivity(), Arm.class);
                startActivity(intent);
                break;
            case R.id.legButton:
                intent = new Intent(getActivity(), Leg.class);
                startActivity(intent);
                break;
        }
    }
}
