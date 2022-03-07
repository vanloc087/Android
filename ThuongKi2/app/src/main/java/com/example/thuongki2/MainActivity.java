package com.example.thuongki2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NhanVien> arrNahnVien = null;
    MyArrayAdapter adapter = null;
    ListView lvNhanVien = null;
    Button btnNhap,btnChonHinh;
    Button btnXoa;
    EditText txtMa, txtTen;
    RadioGroup genderGroup;
    String[] dv_List;
    String donVi;
    CheckBox cb_dsnv;
    int REQUEST_CODE_IMG = 123;
    ImageView img_avt ;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_avt = findViewById(R.id.img_avt);
        btnNhap = findViewById(R.id.btn_Nhap);
        btnXoa = findViewById(R.id.btn_Xoa);
        txtMa = findViewById(R.id.et_MaNV);
        txtTen = findViewById(R.id.et_TenNV);
        genderGroup = findViewById(R.id.radio_gioitinh);
        lvNhanVien = findViewById(R.id.ls_NhanVien);
        arrNahnVien = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout,arrNahnVien);
        lvNhanVien.setAdapter(adapter);
        cb_dsnv = findViewById(R.id.cb_dsnv);
        btnChonHinh = findViewById(R.id.btn_ChonHinh);

        //Spinner
        Spinner sp_DonVi = findViewById(R.id.donvi);
        dv_List = getResources().getStringArray(R.array.donvi_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dv_List);
        sp_DonVi.setAdapter(adapter);
        sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donVi = dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNhap();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoa();
            }
        });
        cb_dsnv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                for(int i = lvNhanVien.getChildCount() - 1; i>=0;i--){
                    View v = lvNhanVien.getChildAt(i);
                    CheckBox chk = v.findViewById(R.id.chk_item);
                    if(cb_dsnv.isChecked()==false){
                        chk.setChecked(false);
                    }
                    else {
                        chk.setChecked(true);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

        btnChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_IMG);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(requestCode == REQUEST_CODE_IMG && resultCode== RESULT_OK && data !=null){
           Uri uri = data.getData();
           try {
               InputStream inputStream = getContentResolver().openInputStream(uri);
               bitmap = BitmapFactory.decodeStream(inputStream);
               img_avt.setImageBitmap(bitmap);
               System.out.println(img_avt.getResources().toString());
           }catch (FileNotFoundException e) {

           };
       }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void xuLyNhap(){
        String ma =  txtMa.getText().toString();
        String ten = txtTen.getText().toString();
        String gioiTinh = "Nam";
        Bitmap hinhAnh = ((BitmapDrawable)img_avt.getDrawable()).getBitmap();
        if(genderGroup.getCheckedRadioButtonId()== R.id.radio_Nu){
            gioiTinh = "Nữ";
        }

        NhanVien nv = new NhanVien();
        nv.setHinhAnh(hinhAnh);
        nv.setMaso(ma);
        nv.setHoten(ten);
        nv.setGioitinh(gioiTinh);
        nv.setDonvi(donVi);

        arrNahnVien.add(nv);
        adapter.notifyDataSetChanged();
        txtMa.setText("");
        txtTen.setText("");
        txtMa.requestFocus();
    }
    private void xuLyXoa(){

        for(int i = lvNhanVien.getChildCount() - 1; i>=0;i--){
            View v = lvNhanVien.getChildAt(i);
            CheckBox chk = v.findViewById(R.id.chk_item);
            if(chk.isChecked()){
                arrNahnVien.remove(i);
            }
        }
        adapter.notifyDataSetChanged();

    }
}