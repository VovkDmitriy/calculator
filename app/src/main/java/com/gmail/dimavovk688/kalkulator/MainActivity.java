package com.gmail.dimavovk688.kalkulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bDot, bPlus, bMinus, bMultiplication, bDivision, bClearOne, bClear, bEquals;
    private TextView display;
    private String PARCELABLE_TAG = "Calculator";
    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        display = findViewById(R.id.display);
        display.setText(String.valueOf(0));
        b1 = findViewById(R.id._1);
        b2 = findViewById(R.id._2);
        b3 = findViewById(R.id._3);
        b4 = findViewById(R.id._4);
        b5 = findViewById(R.id._5);
        b6 = findViewById(R.id._6);
        b7 = findViewById(R.id._7);
        b8 = findViewById(R.id._8);
        b9 = findViewById(R.id._9);
        b0 = findViewById(R.id._0);
        bPlus = findViewById(R.id.plus);
        bMinus = findViewById(R.id.minus);
        bMultiplication = findViewById(R.id.multiplication);
        bDivision = findViewById(R.id.division);
        bDot = findViewById(R.id.dot);
        bClearOne = findViewById(R.id.clear_one);
        bClear = findViewById(R.id.clear);
        bEquals = findViewById(R.id.equals);

        /////////////////////////////////////////////////////////////////////////////////

        Log.e("MyLog", calculator.getInNum());
        Log.e("MyLog", calculator.getTask());

        ///////////////////////////////////////////////////////////////////////////////
        setListeners();
    }



    private void setListeners(){
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        bDot.setOnClickListener(this);
        bPlus.setOnClickListener(this);
        bMinus.setOnClickListener(this);
        bMultiplication.setOnClickListener(this);
        bDivision.setOnClickListener(this);
        bClearOne.setOnClickListener(this);
        bClear.setOnClickListener(this);
        bEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id._1){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("1");
            }
            else calculator.addNum("1");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._2){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("2");
            }
            else calculator.addNum("2");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._3){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("3");
            }
            else calculator.addNum("3");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._4){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("4");
            }
            else calculator.addNum("4");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._5){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("5");
            }
            else calculator.addNum("5");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._6){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("6");
            }
            else calculator.addNum("6");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._7){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("7");
            }
            else calculator.addNum("7");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._8){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("8");
            }
            else calculator.addNum("8");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._9){
            if (calculator.getInNum().equals("0")){
                calculator.setFirstNum("9");
            }
            else calculator.addNum("9");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id._0){
            if (calculator.getInNum().equals("0")){
                calculator.addNum(".0");
            }
            else calculator.addNum("0");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.dot){
            if (!calculator.getInNum().contains(".")){
                calculator.addNum(".");
            }

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.plus){
            //calculator.addition();
            calculator.addNumToTask("+");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.minus){
            //calculator.subtraction();

            calculator.addNumToTask("-");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.multiplication){
            //calculator.multiplication();
            calculator.addNumToTask("*");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.division){
            //calculator.division();
            calculator.addNumToTask("/");

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.clear){
            calculator.clear();

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.clear_one){
            calculator.deleteNum();

            display.setText(calculator.getTask());
            Log.e("MyLog", calculator.getInNum());
            Log.e("MyLog", calculator.getTask());
        }
        else if (v.getId() == R.id.equals){

            display.setText(calculator.equals());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(PARCELABLE_TAG, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable(PARCELABLE_TAG);
        display.setText(calculator.getTask());
    }
}