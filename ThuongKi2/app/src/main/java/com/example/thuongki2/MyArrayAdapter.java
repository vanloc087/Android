package com.example.thuongki2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context = null;
    ArrayList<NhanVien> myArray = null;
    int layoutId;

    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<NhanVien> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.myArray = objects;
        this.layoutId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);

        if (myArray.size()>0 && position>=0){
            final TextView txtDisplay = convertView.findViewById(R.id.tv_item);
            final NhanVien nv = myArray.get(position);
            txtDisplay.setText(nv.toString());
            Bitmap hinhAnh = nv.getHinhAnh();
            final ImageView imgitem = convertView.findViewById(R.id.img_item);
            imgitem.setImageBitmap(hinhAnh);
        }
        return convertView;
    }

}
