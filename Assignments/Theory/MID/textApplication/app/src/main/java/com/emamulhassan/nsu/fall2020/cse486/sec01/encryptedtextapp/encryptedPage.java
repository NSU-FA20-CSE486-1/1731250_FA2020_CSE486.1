package com.emamulhassan.nsu.fall2020.cse486.sec01.encryptedtextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class encryptedPage extends AppCompatActivity {

    TextView sPhn, EncMsg, EncKey;
    Button sendBtn;
    String phnNumb, encMsg, encKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypted_page);

        sPhn = findViewById(R.id.sPhoneNumber);
        EncMsg = findViewById(R.id.sMessage);
        EncKey = findViewById(R.id.sEncryptKey);
        sendBtn = findViewById(R.id.sEncryptBtn);

        Bundle bundle1 = getIntent().getExtras();
        phnNumb = bundle1.getString("User_phn");
        encMsg = bundle1.getString("Enc_msg");
        encKey = bundle1.getString("User_key");

        sPhn.setText("Phone Number: "+phnNumb);
        EncMsg.setText("Encrypted Message: "+encMsg);
        EncKey.setText("Encryption Key: "+encKey);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto: "+phnNumb);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Message "+encMsg+ "Key: "+encKey);
                startActivity(intent);
            }
        });

    }
}