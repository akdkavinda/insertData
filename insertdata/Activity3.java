package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    private Button btnup;
    private Button btnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //for upload PDF button
        btnup = (Button) findViewById(R.id.btnup);
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUploadPaper();
            }
        });

        //for upload Marks button
        btnum = (Button) findViewById(R.id.btnum);
        btnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUploadMarks();
            }
        });


    }

    //for upload button
    public void openUploadPaper() {
        Intent intent = new Intent(this, uploadPaper.class);
        startActivity(intent);

    }

    //for upload Marks button
    private void openUploadMarks() {
        Intent intent = new Intent(this, InsertMarks.class);
        startActivity(intent);
    }
}