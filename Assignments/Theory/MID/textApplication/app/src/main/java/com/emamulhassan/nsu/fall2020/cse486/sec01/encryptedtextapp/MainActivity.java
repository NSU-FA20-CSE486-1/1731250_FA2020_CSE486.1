package com.emamulhassan.nsu.fall2020.cse486.sec01.encryptedtextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText inputPhone, inputMessage, inputKey;
    Button encButton;
    String outputString, AES = "AES", encKey, phnNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPhone = findViewById(R.id.phoneNumber);
        inputMessage = findViewById(R.id.message);
        inputKey = findViewById(R.id.encryptKey);
        encButton = findViewById(R.id.encryptBtn);

        encButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    outputString = encrypt(inputMessage.getText().toString(), inputKey.getText().toString());
                    phnNum = inputPhone.getText().toString();
                    encKey = inputKey.getText().toString();
                    startNewActivity();
                }

                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void startNewActivity(){
        Intent intent1 = new Intent(MainActivity.this, encryptedPage.class);
        Bundle bundle1 = new Bundle();
        bundle1.putString("User_phn", phnNum);
        bundle1.putString("Enc_msg", outputString);
        bundle1.putString("User_key", encKey);

        intent1.putExtras(bundle1);
        startActivity(intent1);

    }

    private String encrypt(String toString, String toString1) {

    }
}