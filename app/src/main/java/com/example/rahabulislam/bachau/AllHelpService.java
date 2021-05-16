package com.example.rahabulislam.bachau;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AllHelpService extends AppCompatActivity {

    //Button call, massage, map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_help_service);



        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String message = b.getString("message");
        String phone = b.getString("phone");
        String email= b.getString("email");
        int img = b.getInt("image");
        //toolbar.setTitle(name);
        //setSupportActionBar(toolbar);

        LinearLayout linearLayoutPhone = findViewById(R.id.phoneLT);
        LinearLayout linearLayoutEmail = findViewById(R.id.emailLT);

        ImageView imageView =  findViewById(R.id.imgID1);
        TextView tvName = findViewById(R.id.nameID1);
        TextView tvId = findViewById(R.id.messageID1);
        final TextView tvPhone = findViewById(R.id.phoneID1);
        final TextView tvEmail = findViewById(R.id.emailID1);

        tvName.setText(name);
        //tvId.setText("Id: "+message);
        tvId.setText(message);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        imageView.setImageResource(img);

        linearLayoutEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                String uri = "mailto: "+tvEmail.getText().toString();
                intent.setData(Uri.parse(uri));
                startActivity(Intent.createChooser(intent,"Send To"));
            }
        });

        linearLayoutPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String uri = "tel: "+tvPhone.getText().toString();
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });





        /*final Button call = findViewById(R.id.callBtnID);
        *//*massage = findViewById(R.id.massageBtnID);
        map = findViewById(R.id.locationBtnID);*//*
        ImageView image = findViewById(R.id.policePicID);
        TextView name = findViewById(R.id.policeBtnID);

        Bundle b = getIntent().getExtras();

        String string = b.getString("Name");
        int pic = b.getInt("Image");
        String contact = b.getString("Contact");
        //final String contact = b.getString("Contact");
        //final int contact = b.getInt("01712858211");
        //final String link = b.getString("Link");

        image.setImageResource(pic);
        name.setText(string);
        call.setText(contact);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String uri = "tel: "+call.getText().toString();
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });*/


        /*call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);

            }
        });*/

    }
}
