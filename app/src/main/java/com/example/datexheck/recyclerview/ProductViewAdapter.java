package com.example.datexheck.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datexheck.R;
import com.example.datexheck.entities.Product;

import java.util.List;

public class ProductViewAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<Product> products;
    private Context context;
    private OnProductListener onProductListener;

    public ProductViewAdapter(List<Product> products, Context context, OnProductListener onProductListener) {
        this.products = products;
        this.context = context;
        this.onProductListener = onProductListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the custom layout
        LayoutInflater inflater = LayoutInflater.from(context);

        View productView = inflater.inflate(R.layout.recycler_item_view, parent, false);

        //Return a new holder instance.
        ProductViewHolder productViewHolder = new ProductViewHolder (productView,onProductListener);
        return productViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        //get the data from the list, based on position
        Product product = products.get(position);

        holder.updateProduct(product);

        holder.bind(product, onProductListener);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void addItem(Product product) {
        products.add(product);

        notifyItemInserted(getItemCount());
    }

    public void replaceItem(int position, Product product) {
        products.set(position, product);
        notifyItemChanged(position);
    }

    public List<Product> getProducts() {
        return products;
    }
}
