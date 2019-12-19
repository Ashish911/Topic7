package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

import helper.Myhelper;

public class MainActivity extends AppCompatActivity {

    EditText etWord,etMeaning;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnSave = findViewById(R.id.btnAddWord);

        final Myhelper myhelper = new Myhelper(this);
        final SQLiteDatabase sqLiteDatabase = myhelper.getWritableDatabase();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Save();

                long id = myhelper.InsertData(etWord.getText().toString(), etMeaning.getText().toString(), sqLiteDatabase);
                if (id > 0){
                    Toast.makeText(MainActivity.this, "Successful" + id, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

//    private void Save(){
//        try {
//            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
//            printStream.println(etWord.getText().toString() + " -> " + etMeaning.getText().toString());
//            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
//        } catch (IOException e){
//            Log.d("Dictionary app", "Error" + e.toString());
//            e.printStackTrace();
//        }
//    }
}
