package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LVactivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    TextView tvx1, tvN, tvD,tvSn;
    Intent gi;
    double etFirst, etD, sum = 0, num1;
    String [] arrSequence = new String[20];
    String str;
    boolean sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvactivity);

        gi = getIntent();
        etFirst = gi.getDoubleExtra("firstNum",0);
        etD = gi.getDoubleExtra("Dnum",0);
        sw = gi.getBooleanExtra("switch",false);
        lv = (ListView) findViewById(R.id.lv);
        tvx1 = findViewById(R.id.x1);
        tvN = findViewById(R.id.n);
        tvD = findViewById(R.id.d);
        tvSn = findViewById(R.id.Sn);
        tvx1.setText("" + etFirst);
        tvD.setText("" +etD);

        if (sw == true){
            for (int i = 0; i < 20; i++){
                num1 = etFirst * Math.pow(etD,i);
                str = String.valueOf(num1);
                if (str.contains("E")){
                    NumberFormat num = new DecimalFormat();
                    num = new DecimalFormat("0.####E0");
                    arrSequence[i] = num.format(num1);
                }
                else{
                    arrSequence[i] = str;
                }
            }
        }
        else {
            for (int i = 0; i < 20; i++) {
                num1 = etFirst + (i)*etD;
                str = String.valueOf(num1);
                if (str.contains("E")){
                    NumberFormat num = new DecimalFormat();
                    num = new DecimalFormat("0.####E0");
                    arrSequence[i] = num.format(num1);
                }
                else{
                    arrSequence[i] = str;
                }
            }
        }

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String >(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrSequence);
        lv.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvN.setText("" +position+1);
        if(sw == true) {
            for (int i = position; i < 20; i++) {
                sum = (position*(Math.pow(etD,i)-1))/ (etD-1);
            }
        }
        else {
            for (int i = position; i < 20; i++) {
                sum = (i*(position+i))/2;
            }
        }
        tvSn.setText("" +sum);
    }
}