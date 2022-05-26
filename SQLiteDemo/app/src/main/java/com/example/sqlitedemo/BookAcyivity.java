package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookAcyivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        EditText etId = findViewById(R.id.etIdbook);
        EditText etTitle = findViewById(R.id.etTitle);
        EditText etIdAuthor = findViewById(R.id.etIdauthor);
        GridView gridView = findViewById(R.id.GridView_Book);

        DBHelper dbHelper = new DBHelper(this);

        Button btnSave = findViewById(R.id.btnSave);
        Button btnSelect = findViewById(R.id.btnSelect);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnUpdate = findViewById(R.id.btnUpdate);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book(Integer.parseInt(etId.getText().toString()),etTitle.getText().toString(),Integer.parseInt(etIdAuthor.getText().toString()));
                if(dbHelper.insertBook(book)>0){
                    Toast.makeText(getApplicationContext(),"Thành công",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sắp thành công ",Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(etId.getText().toString()+"ket qua");
                try {
                    Book book;
                    ArrayList<String> list_String = new ArrayList<>();
                    book = dbHelper.getIdBook(Integer.parseInt(etId.getText().toString()));
                    list_String.add(book.getId() + "");
                    list_String.add(book.getTitle());
                    list_String.add(book.getId_author()+"");
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(BookAcyivity.this, android.R.layout.simple_list_item_1, list_String);
                    gridView.setAdapter(adapter);


                } catch (NumberFormatException ex){
                    ArrayList<Book> list_Book;
                    ArrayList<String> list_String = new ArrayList<>();
                    list_Book = dbHelper.getAllBook();
                    for (Book book : list_Book) {
                        list_String.add(book.getId() + "");
                        list_String.add(book.getTitle());
                        list_String.add(book.getId_author()+"");
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(BookAcyivity.this, android.R.layout.simple_list_item_1, list_String);
                    gridView.setAdapter(adapter);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteBook(Integer.parseInt(etId.getText().toString()));

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book(Integer.parseInt(etId.getText().toString()),etTitle.getText().toString(),Integer.parseInt(etIdAuthor.getText().toString()));
                dbHelper.updateBook(book);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Book book;
//                ArrayList<String> list_String = new ArrayList<>();
//                book = dbHelper.getIdBook(i);
//
//                System.out.println(i);
//                etId.setText(book.getId() + "");
//                etTitle.setText(book.getTitle());
//                etIdAuthor.setText(book.getId_author()+"");
            }
        });





    }
}