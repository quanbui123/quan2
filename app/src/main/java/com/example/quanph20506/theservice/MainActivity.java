package com.example.quanph20506.theservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText txtdata;
Button btnstar,btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtdata=findViewById(R.id.txt_date);
        btnstar=findViewById(R.id.btn_star);
        btnstop=findViewById(R.id.btn_stop);
        btnstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clickstar();
            }

            private void Clickstar() {
                Intent intent= new Intent(MainActivity.this,myservice.class);
               intent.putExtra("datainten",txtdata.getText().toString().trim());
                startService(intent);
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clickstop();
            }

            private void Clickstop() {
                Intent intent= new Intent(MainActivity.this,myservice.class);
                stopService(intent);

            }
        });
    }
}