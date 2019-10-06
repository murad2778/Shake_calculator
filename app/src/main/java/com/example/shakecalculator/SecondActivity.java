package com.example.shakecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.seismic.ShakeDetector;

public class SecondActivity extends AppCompatActivity implements ShakeDetector.Listener {

    TextView result,hint;
    EditText number1;
    Button sin,cos,tan, sqr,std;
    private SensorManager SM;
    ShakeDetector SD;

    double result_num;
    double num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result = (TextView) findViewById(R.id.result);
        hint= (TextView) findViewById(R.id.hint);

        number1 = (EditText) findViewById(R.id.number1);

        sin= (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        sqr = (Button) findViewById(R.id.sqr);
        std = findViewById(R.id.standard);
        SM=(SensorManager)getSystemService((SENSOR_SERVICE));
        SD=new ShakeDetector(this);
        SD.start(SM);

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(SecondActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("sin"+num1);
                num1=Math.toRadians(num1);
                result_num = Math.sin(num1);
                result.setText(String.valueOf(result_num));

            }


        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(SecondActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("cos"+num1);
                //num2 = Integer.parseInt(number2.getText().toString());
                num1=Math.toRadians(num1);
                result_num =Math.cos(num1);

                result.setText(String.valueOf(result_num));

            }


        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(SecondActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("tan"+num1);
                //num2 = Integer.parseInt(number2.getText().toString());
                num1=Math.toRadians(num1);
                result_num =Math.tan(num1);
                result.setText(String.valueOf(result_num));


            }


        });

        sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(SecondActivity.this,"Please Enter Input",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                hint.setText("log "+num1);
                result_num = Math.log(num1);
                result.setText(String.valueOf(result_num));

            }


        });

        std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void hearShake() {
        Intent i = new Intent(SecondActivity.this,MainActivity.class);
        SD.stop();
        startActivity(i);
    }
}