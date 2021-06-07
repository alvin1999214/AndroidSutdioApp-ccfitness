package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SettingFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.setting_fragment, container, false);


        ImageButton fitbit = (ImageButton) view.findViewById(R.id.Fitb);
        ImageButton garmin = (ImageButton) view.findViewById(R.id.garminb);
        ImageButton googlefit = (ImageButton) view.findViewById(R.id.googlefb);
        Button help = (Button) view.findViewById(R.id.help);
        Button email = (Button) view.findViewById(R.id.email);
        Button donation = (Button) view.findViewById(R.id.Donation);
        Button service = (Button) view.findViewById(R.id.Service);
        Button privacy = (Button) view.findViewById(R.id.Privacy);

        fitbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fitbit.com/hk/home"));
                startActivity(i);
            }
        });
        garmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.garmin.com/en-US/"));
                startActivity(i);
            }
        });
        googlefit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/fit/"));
                startActivity(i);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Hmm,This function isn't available now ",Toast.LENGTH_SHORT).show();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Hmm,This function isn't available now ",Toast.LENGTH_SHORT).show();
            }
        });
        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Hmm,This function isn't available now ",Toast.LENGTH_SHORT).show();
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ToS.class);
                startActivity(i);
            }
        });
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Privacy.class);
                startActivity(i);
            }
        });
        return view;
    }
}
