package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public static final int resultCode=22;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     /*   TextView txtNumA=findViewById(R.id.txt_num_a);
        TextView txtUser=findViewById(R.id.txt_user);

        Intent intent=getIntent();
        int numA=intent.getIntExtra("NUM_A",0);
        User user= (User) intent.getSerializableExtra("User");
        txtNumA.setText((numA+""));
        txtUser.setText(user.toString());*/
        TextView txtNumA=findViewById(R.id.txt_num_a);
        TextView txtNumB=findViewById(R.id.txt_num_b);
        Button btnCal=findViewById(R.id.btn_cal);
        final Intent intent = getIntent();
        Bundle bundle =intent.getExtras();
       if (bundle!=null){
           int numA=bundle.getInt("NUM_A",0);
           int numB=bundle.getInt("NUM_B",0);
           txtNumA.setText(numA+"");
           txtNumB.setText(numB+"");
           intent.putExtra("SUM",numA+numB);
       }

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Main2Activity.resultCode,intent);
                finish();
            }
        });
    }
}
