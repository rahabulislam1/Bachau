package com.example.rahabulislam.bachau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dhaka extends AppCompatActivity {

    Button Dhaka, Faridpur, Gazipur, Gopalganj, Kishoreganj, Madaripur, Manikganj, Munshiganj, Narayanganj, Narsingdi, Rajbari, Shariatpur, Tangail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka);

        Tangail = findViewById(R.id.TangailID);
        Gazipur = findViewById(R.id.GazipurID);
        Gopalganj = findViewById(R.id.GopalganjID);
        Dhaka = findViewById(R.id.DhakaDisID);
        Faridpur = findViewById(R.id.FaridpurID);
        Kishoreganj = findViewById(R.id.KishoreganjID);
        Madaripur = findViewById(R.id.MadaripurID);
        Manikganj = findViewById(R.id.ManikganjID);
        Munshiganj = findViewById(R.id.MunshiganjID);
        Narayanganj = findViewById(R.id.NarayanganjID);
        Narsingdi = findViewById(R.id.NarsingdiID);
        Shariatpur = findViewById(R.id.ShariatpurID);
        Rajbari = findViewById(R.id.RajbariID);



        Tangail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dhaka.this,Tangail.class);
                startActivity(intent);
            }
        });

        Gazipur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dhaka.this,Gazipur.class);
                startActivity(intent);
            }
        });

        Dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dhaka.this,DhakaDis.class);
                startActivity(intent);
            }
        });

        Faridpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dhaka.this,Faridpur.class);
                startActivity(intent);
            }
        });



        Gopalganj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dhaka.this,Gopalganj.class);
                startActivity(intent);
            }
        });


    }
}
