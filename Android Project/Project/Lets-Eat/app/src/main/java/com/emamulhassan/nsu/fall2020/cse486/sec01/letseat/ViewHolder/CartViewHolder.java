package com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.Interface.ItemClickListner;
import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView txtProductName, txtProductPrice, txtProductQuantity;
    private ItemClickListner itemClickListner;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        txtProductName = itemView.findViewById(R.id.cart_product_name);
        txtProductPrice = itemView.findViewById(R.id.cart_product_price);
        txtProductQuantity = itemView.findViewById(R.id.cart_product_quantity);

    }

    @Override
    public void onClick(View view)
    {
        itemClickListner.onClick(view, getAdapterPosition(), false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner)
    {
        this.itemClickListner = itemClickListner;
    }
}