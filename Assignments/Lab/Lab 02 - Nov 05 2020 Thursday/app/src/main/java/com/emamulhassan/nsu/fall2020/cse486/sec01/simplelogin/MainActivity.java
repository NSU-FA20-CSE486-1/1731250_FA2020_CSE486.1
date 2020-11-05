package com.emamulhassan.nsu.fall2020.cse486.sec01.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit (View view){
        EditText nameET = findViewById(R.id.userName);
        EditText passwordET = findViewById(R.id.passWord);

        String userName = nameET.getText().toString();
        String passWordET = passwordET.getText().toString();
        Toast.makeText(this, userName +"  "+passWordET, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();

    }
}