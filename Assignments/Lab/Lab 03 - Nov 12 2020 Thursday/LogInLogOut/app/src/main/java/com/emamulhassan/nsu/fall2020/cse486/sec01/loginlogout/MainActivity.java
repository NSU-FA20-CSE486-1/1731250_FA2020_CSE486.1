package com.emamulhassan.nsu.fall2020.cse486.sec01.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, pass;
    Button clk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= (EditText) findViewById(R.id.username);
        pass= (EditText) findViewById(R.id.password);
        clk= (Button) findViewById(R.id.button);
    }

    public void movepage(View view) {
        String stname= name.getText().toString();
        String stpass= pass.getText().toString();
        if(stname.equals("Emam") && stpass.equals("12345"))
        {
            Intent in = new Intent(MainActivity.this,MainActivity2.class);
            Bundle bundle = new Bundle();
            bundle.putString("uname", stname);
            in.putExtras(bundle);
            startActivity(in);
        }

        else if (stname.equals("") || stpass.equals(""))
        {
            Toast.makeText(getBaseContext(),"ENTER BOTH USERNAME AND PASSWORD", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(getBaseContext(),"INCORRECT USERNAME OR PASSWORD", Toast.LENGTH_SHORT).show();
        }



    }
}