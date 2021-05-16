package com.example.rahabulislam.bachau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class DhakaDis extends AppCompatActivity {

    String workerNames [] = {"ARMY", "hotel", "restaurant", "library", "busService", "trainService"};

    //

    String workerPhone []= {"01521444047","01915100678","01711025716","01712858211","01521444047","01915100678"};
    //

    String workerMessage []= {"01521444047","01915100678","01711025716","01712858211","01521444047","01915100678"};
    //
    String workerEmail []= {"mahmudulhasan1@gmail.com","rahabulislam1@gmail.com","belalcse@gmail.com","mahmudulhasan@gmail.com","rahabulislam1@gmail.com","rahabulislamcse@gmail.com"}; //

    int workerImage[] = {R.drawable.army,R.drawable.hotel,R.drawable.restaurant,R.drawable.library_new,R.drawable.bus_service,R.drawable.train_service};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_dis);

        ListView lv = (ListView) findViewById(R.id.listViewDhakaDis);
        CustomAdapter adapter = new CustomAdapter(workerNames,workerPhone,workerMessage,workerEmail,workerImage,this);
        //CustomAdapter adapter = new CustomAdapter(this, workDataList);
        //CustomAdapter adapter = new CustomAdapter(this, workDataList);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String phone = workerPhone[position];

                Intent intent = new Intent(DhakaDis.this,AllHelpService.class);
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
