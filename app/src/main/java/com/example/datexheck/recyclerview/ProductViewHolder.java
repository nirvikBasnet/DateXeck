package com.example.datexheck.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datexheck.Entities.Products;
import com.example.datexheck.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {


    public final TextView productName;
    public final TextView productDescription;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        productName = itemView.findViewById(R.id.productName);
        productDescription = itemView.findViewById(R.id.productDescription);

    }

    public void updateProduct(Products product){

        this.productName.setText(product.getName());
        this.productDescription.setText(product.getExpDate());

    }
}
