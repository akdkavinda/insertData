package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText stdName,stdId;
    Button btn1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        stdName= (EditText)findViewById(R.id.stdName);
        stdId=(EditText)findViewById(R.id.stdId);
        btn1=(Button)findViewById(R.id.btn1);


    }
}