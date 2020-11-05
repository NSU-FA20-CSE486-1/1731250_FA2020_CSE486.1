package com.emamulhassan.nsu.fall2020.cse486.sec01.inlabpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int count=0;
    private TextView countTextView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countTextView = (TextView) findViewById(R.id.textView_Count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_label_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void updateCount(View view) {
        count++;
        if (countTextView != null){
            countTextView.setText(Integer.toString(count));
        }
    }
}