package com.emamulhassan.nsu.fall2020.cse486.sec01.showdateandtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowDateAndTime extends AppCompatActivity {

    TextView d,m,y,h,mi,di;
    String date,month,year,hour,min,divi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_date_and_time);

        d=findViewById(R.id.result1);
        m=findViewById(R.id.result2);
        y=findViewById(R.id.result3);
        h=findViewById(R.id.result4);
        mi=findViewById(R.id.result5);
        di=findViewById(R.id.result6);

        Bundle bundle1 = getIntent().getExtras();
        date = bundle1.getString("date_s");
        month=bundle1.getString("month_s");
        year=bundle1.getString("year_s");
        hour=bundle1.getString("hour_s");
        min=bundle1.getString("min_s");
        divi=bundle1.getString("div_s");

        d.setText("Date: "+date);
        m.setText("Month: "+month);
        y.setText("Year: "+year);
        h.setText("  |  "+hour+" Hour");
        mi.setText(min+" Minute");
        di.setText(divi);


    }
}