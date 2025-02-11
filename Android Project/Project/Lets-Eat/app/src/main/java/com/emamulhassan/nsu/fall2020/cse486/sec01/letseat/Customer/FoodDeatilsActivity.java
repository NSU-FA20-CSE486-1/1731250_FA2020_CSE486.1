package com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.Customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.Model.Products;
import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.Prevalent.Prevalent;
import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class FoodDeatilsActivity extends AppCompatActivity {

        private Button addToCartButton;
        private ImageView productImage, BackBtn2;
        private ElegantNumberButton numberButton;
        private TextView productPrice, productDescription, productName;
        private String productID = "", state = "Normal";


        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_food_deatils);

            productID = getIntent().getStringExtra("pid");

            addToCartButton = (Button) findViewById(R.id.pd_add_to_cart_button);
            BackBtn2 = (ImageView) findViewById(R.id.backBtn2);
            numberButton = (ElegantNumberButton) findViewById(R.id.number_btn);
            productImage = (ImageView) findViewById(R.id.product_image_details);
            productName = (TextView) findViewById(R.id.product_name_details);
            productDescription = (TextView) findViewById(R.id.product_description_details);
            productPrice = (TextView) findViewById(R.id.product_price_details);


            getProductDetails(productID);

            BackBtn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(FoodDeatilsActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            });


            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if (state.equals("Order Placed") || state.equals("Order Shipped"))
                    {
                        Toast.makeText(FoodDeatilsActivity.this, "you can add purchase more products, once your order is shipped or confirmed.", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        addingToCartList();
                    }
                }
            });
        }


        @Override
        protected void onStart()
        {
            super.onStart();

            CheckOrderState();
        }

        private void addingToCartList()
        {
            String saveCurrentTime, saveCurrentDate;

            Calendar calForDate = Calendar.getInstance();
            SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
            saveCurrentDate = currentDate.format(calForDate.getTime());

            SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
            saveCurrentTime = currentDate.format(calForDate.getTime());

            final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");

            final HashMap<String, Object> cartMap = new HashMap<>();
            cartMap.put("pid", productID);
            cartMap.put("pname", productName.getText().toString());
            cartMap.put("price", productPrice.getText().toString());
            cartMap.put("date", saveCurrentDate);
            cartMap.put("time", saveCurrentTime);
            cartMap.put("quantity", numberButton.getNumber());
            cartMap.put("discount", "");

            cartListRef.child("User View").child(Prevalent.currentOnlineUser.getPhone())
                    .child("Products").child(productID)
                    .updateChildren(cartMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task)
                        {
                            if (task.isSuccessful())
                            {
                                cartListRef.child("Admin View").child(Prevalent.currentOnlineUser.getPhone())
                                        .child("Products").child(productID)
                                        .updateChildren(cartMap)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task)
                                            {
                                                if (task.isSuccessful())
                                                {
                                                    Toast.makeText(FoodDeatilsActivity.this, "Added to Cart List.", Toast.LENGTH_SHORT).show();

                                                    Intent intent = new Intent(FoodDeatilsActivity.this, HomeActivity.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        });
                            }
                        }
                    });
        }


        private void getProductDetails(String productID)
        {
            DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Products");

            productsRef.child(productID).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    if (dataSnapshot.exists())
                    {
                        Products products = dataSnapshot.getValue(Products.class);

                        productName.setText(products.getPname());
                        productPrice.setText(products.getPrice());
                        productDescription.setText(products.getDescription());
                        Picasso.get().load(products.getImage()).into(productImage);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        private void CheckOrderState()
        {
            DatabaseReference ordersRef;
            ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders").child(Prevalent.currentOnlineUser.getPhone());

            ordersRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot)
                {
                    if (dataSnapshot.exists())
                    {
                        String shippingState = dataSnapshot.child("state").getValue().toString();

                        if (shippingState.equals("shipped"))
                        {
                            state = "Order Shipped";
                        }
                        else if(shippingState.equals("not shipped"))
                        {
                            state = "Order Placed";
                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }