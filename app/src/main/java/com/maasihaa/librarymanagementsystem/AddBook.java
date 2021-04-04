package com.maasihaa.librarymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBook extends Activity {

    Button btn_Save;
    EditText textView_Name,textView_Author;
    DBHelper mydb;

    @Override
    public void onBackPressed() {
        finish();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        mydb = new DBHelper(this);

        btn_Save = findViewById(R.id.btn_save);
        textView_Name = findViewById(R.id.textView_Name);
        textView_Author = findViewById(R.id.textView_Author);



        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name =  textView_Name.getText().toString();
                String author = textView_Author.getText().toString();

                if(mydb.insertBook(name, author)){
                    Toast.makeText(getApplicationContext(), "Record Created Successfuly!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}