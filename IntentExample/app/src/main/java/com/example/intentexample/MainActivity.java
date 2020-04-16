package com.example.intentexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int requestCode=12;
    private TextView txtSum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  Button btnNewActivity= findViewById(R.id.btn_new_activity);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("NUM_A",2);
                intent.putExtra("User",new User(0,"John"));
                startActivity(intent);
            }
        });*/
        final EditText edtNumA=findViewById(R.id.edt_num_a);
        final EditText edtNumB=findViewById(R.id.edt_num_b);
        Button btnSum=findViewById(R.id.btn_sum);
         txtSum=findViewById(R.id.txt_sum);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                Bundle bundle =new Bundle();
                bundle.putInt("NUM_A",Integer.parseInt(edtNumA.getText().toString()));
                bundle.putInt("NUM_B",Integer.parseInt(edtNumB.getText().toString()));
                intent.putExtras(bundle);
                startActivityForResult(intent,MainActivity.requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==MainActivity.requestCode&&resultCode==Main2Activity.resultCode){
            if (data!=null){
                int sum =data.getIntExtra("SUM",0);
                txtSum.setText(("Sum ="+sum));
            }

        }
    }
}
