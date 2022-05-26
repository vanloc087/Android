package com.example.gridview_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChiTietSanPham extends AppCompatActivity {

    MainActivity mainActivity =  new MainActivity();
    ArrayList<SanPham> listItems = Fragment_AllSanPham.getSP();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);

        ImageView hinhanh = findViewById(R.id.imageView_avt);
        TextView tv_ten = findViewById(R.id.textView_Ten);
        TextView tv_dongia = findViewById(R.id.textView_DonGia);
        TextView tv_hsd = findViewById(R.id.textView_HSD);
        TextView tv_NSX = findViewById(R.id.textView_NSX);
        TextView tv_thuonghieu = findViewById(R.id.textView_ThuongHieu);
        TextView tv_mota = findViewById(R.id.textView_MoTa);

        int id = getIntent().getExtras().getInt("data");


        tv_mota.setText(listItems.get(id).getMoTa());
        tv_ten.setText(listItems.get(id).getTen());
        tv_thuonghieu.setText("Thương hiệu: "+listItems.get(id).getThuongHieu());
        tv_dongia.setText(listItems.get(id).getDonGia()+" vnđ");
        tv_NSX.setText("NSX: "+listItems.get(id).getNgaySX());
        tv_hsd.setText("HSD:"+listItems.get(id).getHanSuDung());
        hinhanh.setImageResource(listItems.get(id).getHinhAnh());



    }


}
