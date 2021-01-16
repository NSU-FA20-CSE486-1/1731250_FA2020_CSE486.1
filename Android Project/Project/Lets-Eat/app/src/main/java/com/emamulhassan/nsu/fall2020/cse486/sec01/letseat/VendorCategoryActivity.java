package com.emamulhassan.nsu.fall2020.cse486.sec01.letseat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VendorCategoryActivity extends AppCompatActivity {

    private ImageView BreakfastItem;
    private ImageView LunchItem;
    private ImageView DessertItem;
    private ImageView DrinksItem;
    private Button VendorLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_category);

        BreakfastItem = (ImageView) findViewById(R.id.breakfast);

        LunchItem = (ImageView) findViewById(R.id.lunch);

        DessertItem = (ImageView) findViewById(R.id.dessert);

        DrinksItem = (ImageView) findViewById(R.id.drinks);

        VendorLogout = (Button) findViewById(R.id.logout_vendor);


        VendorLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorCategoryActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        BreakfastItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorCategoryActivity.this, VendorAddNewProductActivity.class);
                intent.putExtra("category", "Breakfast Item");
                startActivity(intent);
            }
        });

        LunchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorCategoryActivity.this, VendorAddNewProductActivity.class);
                intent.putExtra("category", "Lunch Item");
                startActivity(intent);
            }
        });


        DessertItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorCategoryActivity.this, VendorAddNewProductActivity.class);
                intent.putExtra("category", "Dessert Item");
                startActivity(intent);
            }
        });


        DrinksItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VendorCategoryActivity.this, VendorAddNewProductActivity.class);
                intent.putExtra("category", "Drinks Item");
                startActivity(intent);
            }
        });


    }
}