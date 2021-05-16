package com.example.rahabulislam.bachau;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Location extends Fragment {



    public Location() {
        // Required empty public constructor
    }

    Button Dhaka,Mymensingh,Chittagong,Barisal,Khulna,Rajshahi,Rangpur,Sylhet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_location,container,false);

        Button Dhaka = view.findViewById(R.id.DhakaID);
        Button Mymensingh = view.findViewById(R.id.MymensinghID);
        Button Chittagong = view.findViewById(R.id.ChittagongID);
        Button Barisal = view.findViewById(R.id.BarisalID);
        Button Khulna = view.findViewById(R.id.KhulnaID);
        Button Rajshahi = view.findViewById(R.id.RajshahiID);
        Button Rangpur = view.findViewById(R.id.RangpurID);
        Button Sylhet = view.findViewById(R.id.SylhetID);

        Dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Dhaka.class);
                startActivity(intent);
            }
        });

        Mymensingh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Mymensingh.class);
                startActivity(intent);
            }
        });

        Chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Chittagong.class);
                startActivity(intent);
            }
        });

        Barisal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Barisal.class);
                startActivity(intent);
            }
        });

        Khulna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Khulna.class);
                startActivity(intent);
            }
        });

        Rajshahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Rajshahi.class);
                startActivity(intent);
            }
        });

        Rangpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Rangpur.class);
                startActivity(intent);
            }
        });

        Sylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Sylhet.class);
                startActivity(intent);
            }
        });

        return view;

    }

}
