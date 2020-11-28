package com.emamulhassan.nsu.fall2020.cse486.sec01.lab5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Button addItem1;
    String shwapno = "shwapno";


    public static final int TEXT_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.text1);
        t2=(TextView)findViewById(R.id.text2);
        t3=(TextView)findViewById(R.id.text3);
        t4=(TextView)findViewById(R.id.text4);
        t5=(TextView)findViewById(R.id.text5);
        t6=(TextView)findViewById(R.id.text6);
        t7=(TextView)findViewById(R.id.text7);
        t8=(TextView)findViewById(R.id.text8);
        t9=(TextView)findViewById(R.id.text9);
        t10=(TextView)findViewById(R.id.text10);




    }


    public void add(View view) {

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivityForResult(intent,TEXT_REQUEST);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( resultCode==RESULT_OK) {
            if(requestCode==TEXT_REQUEST){
                String result= data.getStringExtra("Res");
                if(result.equals("Rice")){
                    t1.setText(result);
                }
                else if(result.equals("Cake")){
                    t2.setText(result);
                }
                else if(result.equals("Butter")){
                    t3.setText(result);
                }
                else if(result.equals("Cheese")){
                    t4.setText(result);
                }

                else if(result.equals("Lemon")){
                    t6.setText(result);
                }
                else if(result.equals("Carrot")){
                    t7.setText(result);
                }
                else if(result.equals("Ice-cream")){
                    t8.setText(result);
                }
                else if(result.equals("Biscuit")){
                    t9.setText(result);
                }





            }

        }

    }


    public void shwapno(View view) {
        Uri address = Uri.parse("geo:0,0?q="+shwapno);
        Intent intent = new Intent(Intent.ACTION_VIEW,address);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);

        }
        else {
            Toast.makeText(getApplicationContext(),"Can't Open Now", Toast.LENGTH_SHORT).show();
        }

    }
}