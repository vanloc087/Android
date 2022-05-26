package com.example.appone_provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    static final String uri = "content://com.example.appone_provider";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        EditText etId = findViewById(R.id.etId);
        EditText etName = findViewById(R.id.etName);
        EditText etUnit = findViewById(R.id.etUnit);
        EditText etMadein = findViewById(R.id.etMadein);
        GridView gridView_display = findViewById(R.id.GridView_ProductList);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnUpdate= findViewById(R.id.btnUpdate);
        Button btnSelect = findViewById(R.id.btnSelect);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("id",etId.getText().toString());
                values.put("name",etName.getText().toString());
                values.put("unit",etUnit.getText().toString());
                values.put("madein",etMadein.getText().toString());

                Uri product = Uri.parse(uri);
                Uri insert_uri = getContentResolver().insert(product,values);
                Toast.makeText(getApplicationContext(), "Luu thanh cong", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
                Uri product = Uri.parse(uri);
                Cursor cursor = getContentResolver().query(product,null,null,null,"name");
                if(cursor!= null){
                    cursor.moveToFirst();
                    do {
                        list.add(cursor.getInt(0)+"");
                        list.add(cursor.getString(1));
                        list.add(cursor.getString(2));
                        list.add(cursor.getString(3));

                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductActivity.this, android.R.layout.simple_list_item_1,list);
                    gridView_display.setAdapter(adapter);

                }else {
                    Toast.makeText(getApplicationContext(), "Khong co ket qua", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("id",etId.getText().toString());
                values.put("name",etName.getText().toString());
                values.put("unit",etUnit.getText().toString());
                values.put("madein",etMadein.getText().toString());

                String id = etId.getText().toString();
                Uri product = Uri.parse(uri);
                int update_uri = getContentResolver().update(product,values,"id = ?",new String[]{id});
                Toast.makeText(getApplicationContext(), "Sua thanh cong", Toast.LENGTH_SHORT).show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etId.getText().toString();
                Uri product = Uri.parse(uri);
                int delete_uri = getContentResolver().delete(product,"id = ?",new String[]{id});
                Toast.makeText(getApplicationContext(), "Xoa thanh cong", Toast.LENGTH_SHORT).show();

            }
        });

    }

}