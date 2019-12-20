package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UserPermissionActivity extends AppCompatActivity {

    private ImageView imgp;
    private Button btnp;
    private EditText etmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_permission);

        imgp = findViewById(R.id.imageView);
        etmsg = findViewById(R.id.textView);
        btnp = findViewById(R.id.button);

        CheckPermission();

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCamera();
            }
        });

        etmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msgPermission();
            }
        });

    }

    private void loadCamera(){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        }

    }

    private void CheckPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);

        }
    }

    private void msgPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.SEND_SMS, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

}
