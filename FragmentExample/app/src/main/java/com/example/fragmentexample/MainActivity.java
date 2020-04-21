package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager =getSupportFragmentManager();
        final FragmentTransaction transaction =manager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();
        transaction.add(R.id.root,firstFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        Button btnAdd =findViewById(R.id.btn_add);
        Button btnReplace=findViewById(R.id.btn_replace);
        Button btnPop=findViewById(R.id.btn_pop);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.root,new SecondFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.root,new SecondFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().popBackStack();
            }
        });
    }
}
