package com.example.implicitintentexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtLink = findViewById(R.id.edt_link);
        Button btnVisit = findViewById(R.id.btn_visit);

        btnVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(edtLink.getText().toString()));
               startActivity(intent);
            }
        });
    }
}
