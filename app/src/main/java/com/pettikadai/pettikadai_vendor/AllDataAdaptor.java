package com.pettikadai.pettikadai_vendor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllDataAdaptor extends RecyclerView.Adapter<AllDataAdaptor.ReadDataHolder>{
    Context context;
    ArrayList<AllDataModel> mPhotos;
    public AllDataAdaptor(Context context, ArrayList<AllDataModel> mPhotos) {
        this.context = context;
        this.mPhotos = mPhotos;
    }

    @NonNull
    @Override
    public AllDataAdaptor.ReadDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReadDataHolder(LayoutInflater.from(context).inflate(R.layout.all_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AllDataAdaptor.ReadDataHolder holder, int position) {
        holder.name.setText(mPhotos.get(position).getProductName());
        holder.price.setText(Integer.toString(mPhotos.get(position).getPrice()));
        holder.quantity.setText(Integer.toString(mPhotos.get(position).getQuantity()));
        holder.shop_name.setText(mPhotos.get(position).getShopName());
        holder.location.setText(mPhotos.get(position).getShopLocation());
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }
    class ReadDataHolder extends RecyclerView.ViewHolder {
        TextView name, price, quantity, shop_name, location;
        public ReadDataHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
            shop_name = itemView.findViewById(R.id.shop_name);
            location = itemView.findViewById(R.id.location);
        }
    }
}
