package com.example.rahabulislam.bachau;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostWork extends Fragment {

    EditText etName, etCatagory, etContact, etPlace, etPost ;
    Button btnPostWork, btnAvailableWork;

    String w_name, catagory, contact, place, post ;

    DatabaseReference databaseReference;


    public PostWork() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_post_work, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference("Work List");

        etName = view.findViewById(R.id.enterNameID);
        etCatagory = view.findViewById(R.id.enterCatagoryID);
        etContact = view.findViewById(R.id.enterContactID);
        etPlace = view.findViewById(R.id.enterPlaceID);
        etPost = (EditText) view.findViewById(R.id.enterPostID);
        btnPostWork = (Button) view.findViewById(R.id.postWorkID);
        btnAvailableWork = view.findViewById(R.id.availableWorkID);

        btnPostWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();

            }
        });

        btnAvailableWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ViewWorkActivity.class);
                startActivity(intent);
            }
        });

        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public void saveData(){

        w_name = etName.getText().toString().intern();
        catagory = etCatagory.getText().toString().intern();
        contact = etContact.getText().toString().intern();
        place = etPlace.getText().toString().intern();
        post = etPost.getText().toString().intern();

        String  key = databaseReference.push().getKey();

        Work_Data work_data = new Work_Data(w_name, catagory, contact, place, post);

        databaseReference.child(key).setValue(work_data);
        //Toast.makeText(getApplicationContext(),"Login Unsuccessfull",Toast.LENGTH_SHORT).show();

        etName.setText("");
        etCatagory.setText("");
        etContact.setText("");
        etPlace.setText("");
        etPost.setText("");

    }

}
