package com.example.datexheck.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datexheck.R;
import com.example.datexheck.entities.Product;

class ProductViewHolder extends RecyclerView.ViewHolder {

    public final TextView productName;
    public final TextView productExpDate;
    public final TextView productBarcode;


    private OnProductListener onProductListener;


    public ProductViewHolder(@NonNull View itemView, OnProductListener onProductListener) {
        super(itemView);


        productName = itemView.findViewById(R.id.productNameRecyclerView);
        productExpDate = itemView.findViewById(R.id.expDateRecyclerView);
        productBarcode = itemView.findViewById(R.id.barcodeRecyclerView);

        this.onProductListener = onProductListener;

    }

    public void updateProduct(final Product product){


        this.productName.setText(product.getName());
        //Tags are essentially an extra piece of information that can be associated with a view.
        //They are most often used as a convenience to store data related to views in the views
        //themselves rather than by putting them in a separate structure.
        this.productName.setTag(product.getId());
        this.productExpDate.setText(product.getExpDate());
        this.productBarcode.setText(product.getBarcode());

    }

    public void bind(final Product product, final OnProductListener onProductListener) {
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onProductListener.onProductClick(product);
            }
        });
    }

}
