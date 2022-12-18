package com.pettikadai.pettikadai_vendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReadDataAdaptor extends RecyclerView.Adapter<ReadDataAdaptor.ReadDataHolder> {
    Context context;
    ArrayList<ProductModel> mPhotos;
    public ReadDataAdaptor(Context context, ArrayList<ProductModel> mPhotos) {
        this.context = context;
        this.mPhotos = mPhotos;
    }

    @NonNull
    @Override
    public ReadDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReadDataHolder(LayoutInflater.from(context).inflate(R.layout.item_data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReadDataHolder holder, int position) {
        holder.name.setText(mPhotos.get(position).getProductName());
        holder.price.setText(Integer.toString(mPhotos.get(position).getPrice()));
        holder.quantity.setText(Integer.toString(mPhotos.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
    class ReadDataHolder extends RecyclerView.ViewHolder {
        TextView name, price, quantity;
        public ReadDataHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}
