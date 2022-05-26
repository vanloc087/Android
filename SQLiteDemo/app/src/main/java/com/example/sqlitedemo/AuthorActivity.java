package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        EditText etId = findViewById(R.id.etId);
        EditText etAddress = findViewById(R.id.etAddress);
        EditText etName = findViewById(R.id.etName);
        EditText etEmail = findViewById(R.id.etEmail);
        GridView gridView = findViewById(R.id.GridView);

        DBHelper dbHelper = new DBHelper(this);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnSelect = findViewById(R.id.btnSelect);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author = new Author(Integer.parseInt(etId.getText().toString()),etName.getText().toString(),etAddress.getText().toString(),
                        etEmail.getText().toString());
                if(dbHelper.insertAuthor(author)>0){
                    Toast.makeText(getApplicationContext(),"Thanh cong",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Thanh thu",Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(etId.getText().toString()+"ket qua");
                try {
                    Author author;
                    ArrayList<String> list_String = new ArrayList<>();
                    author = dbHelper.getIdAuthor(Integer.parseInt(etId.getText().toString()));
                    list_String.add(author.getId() + "");
                    list_String.add(author.getName());
                    list_String.add(author.getAddress());
                    list_String.add(author.getEmail());
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, list_String);
                    gridView.setAdapter(adapter);


                } catch (NumberFormatException ex){
                    ArrayList<Author> list_Author;
                    ArrayList<String> list_String = new ArrayList<>();
                    list_Author = dbHelper.getAllAuthor();
                    for (Author author : list_Author) {
                        list_String.add(author.getId() + "");
                        list_String.add(author.getName());
                        list_String.add(author.getAddress());
                        list_String.add(author.getEmail());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, list_String);
                    gridView.setAdapter(adapter);
                }
            }
        });

    }
}