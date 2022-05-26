package com.example.gridview_demo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;

public class MyArrayAdapter extends BaseAdapter {
    Activity context ;
    ArrayList<SanPham> myArray ;
    int layoutId;


    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<SanPham> objects) {
        this.context = context;
        this.myArray = objects;
        this.layoutId = textViewResourceId;
    }

    @Override
    public int getCount() {
        return myArray.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        TextView tv_ma,tv_ten,tv_dongia;
        ImageView imgHinh;
    }

    public void updateListView(ArrayList<SanPham> dsSP) {
        this.myArray = dsSP;
        notifyDataSetChanged();
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId,null);
            holder = new ViewHolder();
            holder.tv_dongia = convertView.findViewById(R.id.tv_dongia);
            holder.tv_ten = convertView.findViewById(R.id.tv_ten);
            holder.imgHinh = convertView.findViewById(R.id.imageAvt);
            convertView.setTag(holder);

        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        SanPham sp = myArray.get(position);
        holder.tv_ten.setText(sp.getTen());
        holder.tv_dongia.setText(sp.getDonGia()+"VNĐ");
        holder.imgHinh.setImageResource(sp.getHinhAnh());

        // gan animation
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list);
        convertView.startAnimation(animation);
        return convertView;
    }

}
