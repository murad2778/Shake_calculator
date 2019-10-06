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

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener  {

    private Sensor mysensor;
    private SensorManager SM;
    TextView result,hint;
    EditText number1, number2;
    Button add, subtract, multiply, divide,sci;

    float result_num;
    float num1, num2;

    ShakeDetector SD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SM=(SensorManager)getSystemService((SENSOR_SERVICE));
        SD=new ShakeDetector(this);
        SD.start(SM);

        result = (TextView) findViewById(R.id.result);
        hint = (TextView) findViewById(R.id.hint);


        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        sci = (Button)findViewById(R.id.scientific);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"+"+num2+"=".trim());
                result_num = num1+num2;
                result.setText(String.valueOf(result_num).trim());


            }


        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"-"+num2+"=".trim());
                result_num = num1-num2;
                result.setText(String.valueOf(result_num).trim());


            }


        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"*"+num2+"=".trim());
                result_num = num1*num2;
                result.setText(String.valueOf(result_num).trim());


            }


        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter First Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(number2.length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter Second Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                num1 = Float.parseFloat(number1.getText().toString());
                num2 = Float.parseFloat(number2.getText().toString());
                hint.setText(num1+"/"+num2+"=".trim());
                result_num = num1/num2;
                result.setText(String.valueOf(result_num).trim());


            }


        });

        sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void hearShake(){
        //getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        SD.stop();
        startActivity(intent);
    }

}
