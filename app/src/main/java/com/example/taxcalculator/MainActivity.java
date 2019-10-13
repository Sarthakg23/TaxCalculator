package com.example.taxcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    TextView t1,t2;
    Button btn;
    float tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.b1);
        final Button btn1=(Button)findViewById(R.id.b2);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v==btn1) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1=(EditText)findViewById(R.id.ed1);
                e2=(EditText)findViewById(R.id.ed2);
                e3=(EditText)findViewById(R.id.ed3);
                e4=(EditText)findViewById(R.id.ed4);
                e5=(EditText)findViewById(R.id.ed5);
                t1=(TextView)findViewById(R.id.text1);
                t2=(TextView)findViewById(R.id.text2);
                float sal = Float.parseFloat(e1.getText().toString());
                float hra = Float.parseFloat(e2.getText().toString());
                float special = Float.parseFloat(e3.getText().toString());
                float lta = Float.parseFloat(e4.getText().toString());
                float deduction = Float.parseFloat(e5.getText().toString());
                float tgs=sal+hra+special+lta-deduction;
                String ts=Float.toString(tgs);
                t1.setText(ts);
                if(tgs<=250000)
                    tax=0;
               else if(tgs>250000&&tgs<=500000)
                {
                    tax=(5*(tgs-250000)/100);
                }
               else if(tgs>500000&&tgs<=1000000)
                {
                    tax=12500+(20*(tgs-500000)/100);
                }
               else if(tgs>1000000)
                {
                    tax=12500+100000+(30*(tgs-1000000)/100);
                }
               float cess=(4*tax)/100;
               tax=tax+cess;
               String t=Float.toString(tax);
               t2.setText(t);


            }
        });


    }
}