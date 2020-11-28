package com.emamulhassan.nsu.fall2020.cse486.sec01.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class MainActivity2 extends AppCompatActivity {
    String rice ="Rice", cake="Cake", butter= "Butter", cheese= "Cheese", lemon ="Lemon", carrot ="Carrot", ice="Ice-cream",bis="Biscuit",panda="Pandamart";
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void addItem1(View view) {
        Intent intent2 = new Intent();
        intent2.putExtra("Res",rice);
        setResult(RESULT_OK,intent2 );
        finish();

    }

    public void addItem2(View view) {
        Intent intent2 = new Intent();
        intent2.putExtra("Res",cake);
        setResult(RESULT_OK,intent2 );
        finish();

    }

    public void addItem3(View view) {
        Intent intent2 = new Intent();
        intent2.putExtra("Res",butter);
        setResult(RESULT_OK,intent2 );
        finish();


    }

    public void addItem4(View view) {
        Intent intent2 = new Intent();
        intent2.putExtra("Res",cheese);
        setResult(RESULT_OK,intent2 );
        finish();
    }

    public void addItem5(View view) {
        Intent intent2 = new Intent();
        intent2.putExtra("Res",lemon);
        setResult(RESULT_OK,intent2 );
        finish();
    }

    public void addItem6(View view) {

        Intent intent2 = new Intent();
        intent2.putExtra("Res",carrot);
        setResult(RESULT_OK,intent2 );
        finish();

    }


    public void addItem7(View view) {
        Intent intent2 = new Intent();
        intent2.putExtra("Res",ice);
        setResult(RESULT_OK,intent2 );
        finish();

    }

    public void addItem8(View view) {
        Intent intent2 = new Intent();
        intent2.putExtra("Res",bis);
        setResult(RESULT_OK,intent2 );
        finish();
    }


    public void panda(View view) {

        Uri address = Uri.parse("geo:0,0?q="+panda);
        Intent intent = new Intent(Intent.ACTION_VIEW,address);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);

        }
        else {
            Toast.makeText(getApplicationContext(),"Can't Open Now", Toast.LENGTH_SHORT).show();
        }

    }
}