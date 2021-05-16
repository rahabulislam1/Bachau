package com.example.rahabulislam.bachau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewWorkActivity extends AppCompatActivity {

    private ListView postWorkListView;
    DatabaseReference databaseReference ;

    private List<Work_Data> workDataList;
    private SampleLayoutAdapter sampleLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_work);

        databaseReference = FirebaseDatabase.getInstance().getReference("Work List");
        workDataList = new ArrayList<>();
        sampleLayoutAdapter = new SampleLayoutAdapter(ViewWorkActivity.this,workDataList);

        postWorkListView = findViewById(R.id.viewWorkListViewID);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                workDataList.clear();

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Work_Data work_data = dataSnapshot1.getValue(Work_Data.class);
                    workDataList.add(work_data);
                }
                postWorkListView.setAdapter(sampleLayoutAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onStart();
    }
}
