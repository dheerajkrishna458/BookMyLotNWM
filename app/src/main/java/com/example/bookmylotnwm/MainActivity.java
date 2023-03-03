package com.example.bookmylotnwm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void signin(View v){
        setContentView(R.layout.type);
    }
    public void next1(View v){
        setContentView(R.layout.typeofvehicle);
    }
    public void next2(View v){
        setContentView(R.layout.parkingplace);
    }
    public void parkingview(View v){
        setContentView(R.layout.parkingview);
        TextView tv= (TextView) findViewById(R.id.ParkingName);
        tv.setText("Library Parking");
    }
    public void reserve(View v){
        setContentView(R.layout.reservation);
    }
    public void success(View v){
        setContentView(R.layout.reservesuccess);
    }
}