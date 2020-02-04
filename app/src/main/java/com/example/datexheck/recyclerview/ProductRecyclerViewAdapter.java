package com.example.datexheck.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datexheck.Entities.Products;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductViewHolder> {


    private List<Products> products;
    private Context context;
    private onProductListener onProductListener;


    public ProductRecyclerViewAdapter (List<Products> products,Context context,onProductListener onProductListener){
        this.products= products;
        this.context=context;
        this.onProductListener=onProductListener;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
