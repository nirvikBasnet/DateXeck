package com.example.datexheck.recyclerview;


import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.example.datexheck.R;
import com.example.datexheck.entities.DataItem;


import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    public static final String ITEM_ID_KEY = "item_id_key";
    private List<DataItem> mItems;
    private Context mContext;

    public DataItemAdapter(Context context, List<DataItem> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, int position) {
        final DataItem item = mItems.get(position);


            holder.tvName.setText(item.getItemName());
            holder.expItemTextView.setText(item.getItemExpDate());


//        //when user selects
//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // Toast.makeText(mContext,"You Selected " + item.getItemName(),Toast.LENGTH_SHORT).show();
//                String itemId = item.getItemId();
//                Intent intent = new Intent (mContext, DetailActivity.class);
//                intent.putExtra(ITEM_ID_KEY,itemId);
//                mContext.startActivity(intent);
//
//
//            }
//        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext,"You Long Selected " + item.getItemName(),Toast.LENGTH_SHORT).show();
                return false;

            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView expItemTextView;
        public View mView;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName =  itemView.findViewById(R.id.itemNameText);
            expItemTextView = itemView.findViewById(R.id.expItemTextView);
            mView = itemView;
        }

    }
}

