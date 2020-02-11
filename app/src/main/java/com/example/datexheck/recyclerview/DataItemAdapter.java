//package com.example.datexheck.recyclerview;
//
//
//import android.content.Context;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.example.datexheck.ListActivity;
//import com.example.datexheck.R;
//import com.example.datexheck.entities.Product;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.DatabaseViewHolder> {
//
//
//    Context context;
//
//    ArrayList<Product> objProductClassArrayList;
//
//
//
//
//    public DataItemAdapter(Context context, ArrayList<Product> objProductClassArrayList) {
//        this.context = context;
//        this.objProductClassArrayList=objProductClassArrayList;
//
//    }
//
//
//    @NonNull
//    @Override
//    public DatabaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View singleRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list,parent,false);
//        return new DatabaseViewHolder(singleRow);
//    }
//
//
//
//
//    @Override
//    public void onBindViewHolder( DatabaseViewHolder holder, int position) {
//
//        Product objProduct = objProductClassArrayList.get(position);
//        holder.nameTextView.setText(objProduct.getProductName());
//        holder.expiryDateTextView.setText(objProduct.getProductExpDate());
//
//
//    }
//
//
//
//
//
//    @Override
//    public int getItemCount() {
//        return objProductClassArrayList.size();
//    }
//
//    public static class DatabaseViewHolder extends  RecyclerView.ViewHolder
//    {
//        TextView nameTextView,expiryDateTextView;
//
//        public DatabaseViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTextView= itemView.findViewById(R.id.itemNameView);
//            expiryDateTextView=itemView.findViewById(R.id.expItemTextView);
//
//
//
//
//        }
//    }
//
//
//
//}
//
