package com.emamulhassan.nsu.fall2020.cse486.sec01.showdateandtime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    String[] months = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] yrs = {"2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
    String[] hrs = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] mins = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30", "31", "32",
            "33", "34", "35", "36", "37", "38", "39", "40"," 41", "42", "43", "44", "45", "46", "47", "48", "49", "50","51","52","53","54","55","56","57","58","59"};
    String [] divs = {"AM","PM"};

    String selectedDate,selectedMonth,selectedYr, selectedHr, selectedMin,selectedDiv;


    Spinner dateSelect, monthSelect, yrSelect, hrSelect, minSelect,divSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateSelect =findViewById(R.id.date);
        monthSelect=findViewById(R.id.month);
        yrSelect =findViewById(R.id.year);
        hrSelect=findViewById(R.id.Hr);
        minSelect =findViewById(R.id.Min);
        divSelect =findViewById(R.id.ampm);

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dates);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dateSelect.setAdapter(arrayAdapter1);

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,months);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        monthSelect.setAdapter(arrayAdapter2);

        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,yrs);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        yrSelect.setAdapter(arrayAdapter3);

        ArrayAdapter arrayAdapter4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,hrs);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        hrSelect.setAdapter(arrayAdapter4);

        ArrayAdapter arrayAdapter5 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mins);
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_item);
        minSelect.setAdapter(arrayAdapter5);

        ArrayAdapter arrayAdapter6 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,divs);
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_item);
        divSelect.setAdapter(arrayAdapter6);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedDate = dateSelect.getItemAtPosition(position).toString();
        selectedMonth = monthSelect.getItemAtPosition(position).toString();
        selectedYr = yrSelect.getItemAtPosition(position).toString();
        selectedHr = hrSelect.getItemAtPosition(position).toString();
        selectedMin = minSelect.getItemAtPosition(position).toString();
        selectedDiv = divSelect.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void btn1(View view) {
        selectedDate = dateSelect.getSelectedItem().toString();
        selectedMonth = monthSelect.getSelectedItem().toString();
        selectedYr = yrSelect.getSelectedItem().toString();
        selectedHr = hrSelect.getSelectedItem().toString();
        selectedMin = minSelect.getSelectedItem().toString();
        selectedDiv = divSelect.getSelectedItem().toString();
        Intent intent1= new Intent(MainActivity.this,ShowDateAndTime.class);

        Bundle bundle1 = new Bundle();


        bundle1.putString("date_s",selectedDate);
        bundle1.putString("month_s",selectedMonth);
        bundle1.putString("year_s",selectedYr);
        bundle1.putString("hour_s",selectedHr);
        bundle1.putString("min_s",selectedMin);
        bundle1.putString("div_s",selectedDiv);

        intent1.putExtras(bundle1);
        intent1.putExtras(bundle1);
        intent1.putExtras(bundle1);
        intent1.putExtras(bundle1);
        intent1.putExtras(bundle1);
        intent1.putExtras(bundle1);

        startActivity(intent1);




    }
}