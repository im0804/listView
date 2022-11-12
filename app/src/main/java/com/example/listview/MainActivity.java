package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etfirst;
    EditText etd;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etfirst = (EditText) findViewById(R.id.etFirst);
        etd = (EditText) findViewById(R.id.etD);
        sw = (Switch) findViewById(R.id.sw);
        etd.setHint("enter a sequence");
        etfirst.setHint("enter the first number");

    }

    public void go(View view) {
        if (etfirst == null){
            Toast.makeText(this, "please enter the first number", Toast.LENGTH_LONG).show();
        }
        if (etd == null){
            Toast.makeText(this, "please enter the sequence's number", Toast.LENGTH_LONG).show();
        }

        Intent si = new Intent(this, LVactivity.class);
        si.putExtra("firstNum", Double.parseDouble(etfirst.getText().toString()));
        si.putExtra("Dnum", Double.parseDouble(etd.getText().toString()));
        si.putExtra("switch",sw.isChecked());
        startActivity(si);
    }
}