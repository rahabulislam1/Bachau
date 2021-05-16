package com.example.rahabulislam.bachau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Gazipur extends AppCompatActivity {

    String workerNames [] = {"MEDICAL","FIRESERVICE","AMBULANCE","POLICE", "RAB", "ARMY"};

    //

    String workerPhone []= {"01712858211","01521444047","01915100678","01711025716","01712858211","01521444047"};
    //

    String workerMessage []= {"01712858211","01521444047","01915100678","01711025716","01712858211","01521444047"};
    //
    String workerEmail []= {"rahabulislam1@gmail.com","belalcse@gmail.com","mahmudulhasan@gmail.com","rahabulislam1@gmail.com","rahabulislamcse@gmail.com","mahmudulhasan1@gmail.com"};

    int workerImage[] = {R.drawable.medical,R.drawable.fire_service1,R.drawable.ambulance,R.drawable.police1,R.drawable.rab,
            R.drawable.army};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gazipur);

        ListView lv = (ListView) findViewById(R.id.listViewGazipur);
        CustomAdapter adapter = new CustomAdapter(workerNames,workerPhone,workerMessage,workerEmail,workerImage,this);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String phone = workerPhone[position];

                Intent intent = new Intent(Gazipur.this,AllHelpService.class);
                intent.putExtra("name",workerNames[position]);
                intent.putExtra("phone",workerPhone[position]);
                intent.putExtra("message",workerMessage[position]);
                intent.putExtra("email",workerEmail[position]);
                intent.putExtra("image",workerImage[position]);
                startActivity(intent);

            }
        });

    }
}
