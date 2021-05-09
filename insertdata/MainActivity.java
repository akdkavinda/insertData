package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button next1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next1=(Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });


        Toast.makeText(MainActivity.this,"Firebase connected successfully", Toast.LENGTH_LONG).show();
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);

    }

}