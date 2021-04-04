package com.maasihaa.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewDatabase extends Activity {

    private ListView obj;
    DBHelper mydb;

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_database);

        mydb = new DBHelper(ViewDatabase.this);
        //Toast.makeText(ViewDatabase.this,mydb.numberOfRows(),Toast.LENGTH_SHORT);


        ArrayList array_list = mydb.getAllBooks();

        Log.d("testing", String.valueOf(array_list));
        ArrayAdapter arrayAdapter = new ArrayAdapter(ViewDatabase.this,R.layout.mylist, array_list);

        obj = (ListView) findViewById(R.id.arraylist);
        obj.setAdapter(arrayAdapter);

        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = String.valueOf(arrayAdapter.getItem(position));
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT);
            }
        });

    }
}