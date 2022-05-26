package com.example.app2provider;

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

public class MainActivity extends AppCompatActivity {

    static  final String AUTHORITY = "com.example.appone_provider";
    static  final String CONTENT_PROVIDER = "contentprovider";
    static  final String URL = "content://"+AUTHORITY+"/"+CONTENT_PROVIDER;
    static  final Uri CONTENT_URI = Uri.parse(URL);
    static  final String uri = "content://com.example.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Uri insert_uri = getContentResolver().insert(CONTENT_URI,values);
                Toast.makeText(getApplicationContext(), "Luu thanh cong", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list = new ArrayList<>();
                Cursor cursor = getContentResolver().query(CONTENT_URI,null,null,null,"name");
                if(cursor!= null){
                    cursor.moveToFirst();
                    do {
                        list.add(cursor.getInt(0)+"");
                        list.add(cursor.getString(1));
                        list.add(cursor.getString(2));
                        list.add(cursor.getString(3));

                    }while (cursor.moveToNext());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,list);
                    gridView_display.setAdapter(adapter);

                }else {
                    Toast.makeText(getApplicationContext(), "Khong co ket qua", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}