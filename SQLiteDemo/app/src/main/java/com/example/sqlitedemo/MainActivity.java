package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnauthor = findViewById(R.id.author);
        Button btnTim = findViewById(R.id.btnTim);
        Button btnbook = findViewById(R.id.book);
        EditText etName = findViewById(R.id.etName);
        GridView gridView = findViewById(R.id.GV_Book);

        DBHelper dbHelper = new DBHelper(this);


        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Book> list_Book;
                ArrayList<String> list_String = new ArrayList<>();
                list_Book = dbHelper.getBookofAuthor(etName.getText().toString());
                for (Book book : list_Book) {
                    list_String.add(book.getId() + "");
                    list_String.add(book.getTitle());
                    list_String.add(book.getId_author()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, list_String);
                gridView.setAdapter(adapter);
            }
        });

        btnauthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AuthorActivity.class);
                startActivity(intent);
            }
        });

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BookAcyivity.class);
                startActivity(intent);
            }
        });
    }
}