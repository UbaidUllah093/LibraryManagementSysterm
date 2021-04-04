package com.maasihaa.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_available_books,btn_search_book,btn_add_new_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_available_books = findViewById(R.id.btn_available);
        btn_add_new_book = findViewById(R.id.btn_add);


        btn_available_books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, ViewDatabase.class);
                //finish();
                startActivity(in);
            }

        });
        btn_add_new_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, AddBook.class);
                //finish();
                startActivity(in);
            }
        });
    }

}