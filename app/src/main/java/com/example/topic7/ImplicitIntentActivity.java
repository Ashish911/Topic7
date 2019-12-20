package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    private EditText etPhoneNo;
    private Button btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        etPhoneNo = findViewById(R.id.etPhone);
        btnDial = findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dial();
            }
        });

    }

    private void Dial(){
        Uri uri = Uri.parse("tel:" + etPhoneNo.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

}
