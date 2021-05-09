package com.example.insertdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class uploadPaper extends AppCompatActivity {

    EditText editText;
    Button btnsubmit;

    StorageReference storageReferance;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_paper);

        editText = findViewById(R.id.editText);
        btnsubmit = findViewById(R.id.btnsubmit);

        storageReferance = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("uploadPDF");

        btnsubmit.setEnabled(false);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPDF();
            }
        });

    }

    private void selectPDF() {

        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"PDF FILE SELECT"),12);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==12 && requestCode==RESULT_OK && data!=null && data.getData()!=null){
            btnsubmit.setEnabled(true);
            editText.setText(data.getDataString().
                    substring(data.getDataString().lastIndexOf("/")+1));
            btnsubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    uploadPDFFileFirebase(data.getData());
                }
            });
        }
    }

    private void uploadPDFFileFirebase(Uri data) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("File is loading...");
        progressDialog.show();

        StorageReference reference = storageReferance.child("upload"+System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete()){
                            Uri uri= uriTask.getResult();

                            putPDF putPDF = new putPDF(editText.getText().toString(),uri.toString());
                            databaseReference.child(databaseReference.push().getKey()).setValue(putPDF);
                            Toast.makeText(uploadPaper.this,"File Upload ",Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();

                        }

                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress=(100.0* snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                progressDialog.setMessage("File Uploaded.."+(int)progress+"%");
            }
        });
    }
}