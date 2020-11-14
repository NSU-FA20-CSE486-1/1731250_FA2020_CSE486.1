package com.emamulhassan.nsu.fall2020.cse486.sec01.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text= (TextView) findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("uname");

        text.setText(data);

    }

    public void movepage2(View view) {
        Intent in = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(in);
    }
}