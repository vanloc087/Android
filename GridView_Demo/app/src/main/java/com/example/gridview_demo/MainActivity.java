package com.example.gridview_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  TruyenSanPham {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView trangChu = findViewById(R.id.trangChu);



    }



    @Override
    public void DataSanPham(SanPham sanPham) {
        if(getSupportFragmentManager().findFragmentById(R.id.fragmentChiTietSanPham)==null){
                    Intent intent = new Intent(this,ChiTietSanPham.class);
                    intent.putExtra("data",sanPham.getId());
                    startActivity(intent);
                }
                else{
                    Fragment_ChiTietSanPham fragment_chiTietSanPham = (Fragment_ChiTietSanPham) getSupportFragmentManager().findFragmentById(R.id.fragmentChiTietSanPham);
                    fragment_chiTietSanPham.setChiTietSanPham(sanPham);
               }

    }
}