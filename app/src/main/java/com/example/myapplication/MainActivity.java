package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
    }
    // data adding part in main program
    public void addData(){
        DbHandler dbHandler = new DbHandler(this);
        boolean state = dbHandler.addInfo("vimu","adb");
        if (state == true)
            Toast.makeText(this, "Data added", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}