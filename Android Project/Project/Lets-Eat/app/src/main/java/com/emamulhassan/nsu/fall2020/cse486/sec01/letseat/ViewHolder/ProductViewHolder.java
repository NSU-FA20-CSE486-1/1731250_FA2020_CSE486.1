package com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.Interface.ItemClickListner;
import com.emamulhassan.nsu.fall2020.cse486.sec01.letseat.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public ImageView imageView;
    public TextView txtProductName, txtProductDescription, txtProductPrice;
    public ItemClickListner listner;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.product_image);
        txtProductName = (TextView) itemView.findViewById(R.id.product_name);
        txtProductDescription = (TextView) itemView.findViewById(R.id.product_description);
        txtProductPrice = (TextView) itemView.findViewById(R.id.product_price);

    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }


    @Override
    public void onClick(View view)
    {
        listner.onClick(view, getAdapterPosition(), false);
    }
}
