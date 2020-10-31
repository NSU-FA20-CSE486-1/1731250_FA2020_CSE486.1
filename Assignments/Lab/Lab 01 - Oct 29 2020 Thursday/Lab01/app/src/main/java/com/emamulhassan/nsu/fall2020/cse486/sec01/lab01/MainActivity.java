package com.emamulhassan.nsu.fall2020.cse486.sec01.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = "Emam";
        if (name.equals(null)){
            Log.e("MainActivity onCreate", "Name is Missing");
        }
        else{
            Log.d("MainActivity onCreate", "Successful");
        }
        Log.e("MainActivity onCreate", "you forgot the date!");

    }
}