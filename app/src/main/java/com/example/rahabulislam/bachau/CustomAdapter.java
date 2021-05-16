package com.example.rahabulislam.bachau;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CustomAdapter extends BaseAdapter {

    String Name [];
    String phone [];
    String message [];
    String email [];
    int image [];
    LayoutInflater inflater;

    //public CustomAdapter(Context cntx, List<>List<Work_Data> workDataList2)

    public CustomAdapter(String[] name, String[] phone,String[] message, String[] email, int[] image, Context cntx) {
        Name = name;               //---------------------------------------------------------------------------------------
        this.phone = phone;
        this.message = message;
        this.email = email;
        this.image = image;
        this.inflater= LayoutInflater.from(cntx);
    }

    @Override
    public int getCount() {
        return Name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= inflater.inflate(R.layout.list_item,parent,false);
        ImageView img = convertView.findViewById(R.id.imgID);
        TextView name = convertView.findViewById(R.id.nameID);
        TextView Message = convertView.findViewById(R.id.messageID);
        TextView Phone = convertView.findViewById(R.id.phoneID);
        TextView Email = convertView.findViewById(R.id.emailID);

        img.setImageResource(image [position]);
        name.setText(Name[position]);
        Message.setText(message[position]);
        Phone.setText(phone[position]);
        Email.setText(email[position]);

        return convertView;

    }
}
