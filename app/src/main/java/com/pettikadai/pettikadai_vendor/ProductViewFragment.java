package com.pettikadai.pettikadai_vendor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ProductViewFragment extends Fragment {
    FirebaseFirestore db;
    ArrayList<ProductModel> mPhotos;
    ArrayList<ProductModel> filteredList;
    RecyclerView rcvData;
    String shopName;
    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_view, container, false);
        rcvData = view.findViewById(R.id.rcvData);
        db = FirebaseFirestore.getInstance();
        getData();
        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });
        return view;
    }

    private void filterList(String newText) {
        filteredList = new ArrayList<>();
        for (ProductModel productModel : mPhotos){
            if (productModel.getProductName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(productModel);
            }

        }
        if (filteredList.isEmpty()){
            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
        }
        else {
            rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
            rcvData.setAdapter(new ReadDataAdaptor(getContext(), filteredList));
        }
    }

    public void getData (){
        mPhotos = new ArrayList<>();
        mPhotos.clear();
        shopName = MainActivity.shopName;
        db.collection("Shop/"+shopName+"/Products").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error==null){
                    List<ProductModel> data = value.toObjects(ProductModel.class);
                    mPhotos.addAll(data);
                    rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
                    rcvData.setAdapter(new ReadDataAdaptor(getContext(), mPhotos));
                    ProductModel temp = mPhotos.get(0);
                }
            }
        });
    }
}