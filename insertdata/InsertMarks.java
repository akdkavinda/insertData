package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertMarks extends AppCompatActivity {

    EditText id,name;
    Button btnOk;
    DatabaseReference reff;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_marks);
        name=(EditText)findViewById(R.id.name);
        id=(EditText)findViewById(R.id.id);
        btnOk=(Button)findViewById(R.id.btnOk);
        student = new Student();
        reff= FirebaseDatabase.getInstance().getReference().child("Student");
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.setId(id.getText().toString().trim());
                student.setName(name.getText().toString().trim());
                reff.push().setValue(student);
                Toast.makeText(InsertMarks.this,"sucessfull",Toast.LENGTH_LONG).show();
            }
        });
    }
}