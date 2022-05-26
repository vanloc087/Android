package com.example.cs5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listview_traicay);

        listItems = getResources().getStringArray(R.array.traicay);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listItems);
//        listView.setAdapter(adapter);



        Spinner spinner = findViewById(R.id.spinner_traicay);

        listItems = getResources().getStringArray(R.array.traicay);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listItems);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String st = listItems[i];
                Toast.makeText(MainActivity.this,st,Toast.LENGTH_SHORT).show();;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        GridView gridView = findViewById(R.id.gridView_TraiCay);
                listItems = getResources().getStringArray(R.array.traicay);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listItems);
//        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView .OnItemClickListener() {
            public void onItemClick(
                    AdapterView<?> arg0,View arg1, int arg2,long arg3) {

                String st = listItems[arg2];
                Toast.makeText(MainActivity.this,st,Toast.LENGTH_SHORT).show();
            }
        });




        
    }
}