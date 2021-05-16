package com.example.rahabulislam.bachau;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SampleLayoutAdapter extends ArrayAdapter<Work_Data> {

    private Activity contex;
    private List<Work_Data> workDatalist;

    public SampleLayoutAdapter(Activity context, List<Work_Data> workDatalist) {
        super(context,  R.layout.sample_layout_list_view_work, workDatalist);
        this.contex =  context;
        this.workDatalist = workDatalist;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = contex.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout_list_view_work,null,true);
        Work_Data work_data = workDatalist.get(position);

        TextView t1 = view.findViewById(R.id.lstNameID);
        TextView t2 = view.findViewById(R.id.lstCatagoryID);
        TextView t3 = view.findViewById(R.id.lstContactID);
        TextView t4 = view.findViewById(R.id.lstLocationID);
        TextView t5 = view.findViewById(R.id.lstDiscriptionID);

        t1.setText("Name:"+work_data.getW_name());
        t2.setText("Catagory:"+work_data.getCatagory());
        t3.setText("Contact:"+work_data.getContact());
        t4.setText("location:"+work_data.getPlace());
        t5.setText("Discription:"+work_data.getPost());

        return view;
    }
}
