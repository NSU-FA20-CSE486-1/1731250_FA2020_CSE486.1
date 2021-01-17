package com.emamulhassan.nsu.fall2020.cse486.sec01.letseat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.Model.VendorOrders;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VendorNewOrdersActivity extends AppCompatActivity {

    private RecyclerView ordersList;
    private DatabaseReference ordersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_new_orders);

        ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders");

        ordersList = findViewById(R.id.orders_list);
        ordersList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<VendorOrders> =
        new FirebaseRecyclerOptions.Builder<VendorOrders>()
                .setQuery(ordersRef, VendorOrders.class)
                .build();

        FirebaseRecyclerAdapter<VendorOrders, VendorOrdersViewHolder> adapter =
                new FirebaseRecyclerAdapter<VendorOrders, VendorOrdersViewHolder>() {
                    @Override
                    protected void onBindViewHolder(@NonNull VendorOrdersViewHolder holder, int position, @NonNull VendorOrders model) {

                    }

                    @NonNull
                    @Override
                    public VendorOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        return null;
                    }
                };

        ordersList.setAdapter(adapter);
        adapter.startListening();
    }

    public static class VendorOrdersViewHolder extends RecyclerView.ViewHolder
    {
        public TextView userName, userPhoneNumber, userTotalPrice, userDateTime, userShippingAddress;
        public Button ShowOrdersBtn;

        public VendorOrdersViewHolder(@NonNull View itemView)
        {
            super(itemView);

            userName = itemView.findViewById(R.id.order_user_name);
            userPhoneNumber = itemView.findViewById(R.id.order_phone_number);
            userTotalPrice = itemView.findViewById(R.id.order_total_price);
            userDateTime = itemView.findViewById(R.id.order_date_time);
            userShippingAddress = itemView.findViewById(R.id.order_address_city);
            ShowOrdersBtn = itemView.findViewById(R.id.show_all_products_btn);
        }
    }
}