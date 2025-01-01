package com.pettikadai.pettikadai_vendor;

import android.os.Bundle;

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

public class CartFragment extends Fragment {

    FirebaseFirestore db;
    ArrayList<ShopModel> shopModels = new ArrayList<>();
    ArrayList<AllDataModel> filteredList;
    ArrayList<AllDataModel> allDataModels;
    ArrayList<ProductModel> productModels;
    RecyclerView rcvData;
    SearchView searchView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
<<<<<<< HEAD
//        rcvData = view.findViewById(R.id.rcvData);
//        db = FirebaseFirestore.getInstance();
//        if (shopModels.isEmpty()){
//            Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//        }
//        db.collection("Shop").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                if(error==null){
//                    List<ShopModel> data = value.toObjects(ShopModel.class);
//                    shopModels.addAll(data);
//                    ShopModel dataModel = shopModels.get(0);
//                    Toast.makeText(getContext(), dataModel.getShopName(), Toast.LENGTH_SHORT).show();
//                }
////                Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//            }
//        });
//        allDataModels = new ArrayList<>();
//        allDataModels.clear();
//        for (ShopModel shopModel:shopModels){
//            String shopName1 = shopModel.getShopName();
//            productModels.clear();
//            db.collection("Shop/"+shopName1+"/Products").addSnapshotListener(new EventListener<QuerySnapshot>() {
//                @Override
//                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                    if(error==null){
//                        List<ProductModel> data = value.toObjects(ProductModel.class);
//                        productModels.addAll(data);
//                        for (ProductModel productModel:productModels){
//                            AllDataModel temp = new AllDataModel(shopModel.getShopName(), shopModel.getShopLocation(), shopModel.getContactNumber(), productModel.getProductName(), productModel.getPrice(), productModel.getQuantity());
//                            allDataModels.add(temp);
//                        }
//                        if (productModels.isEmpty()) {
//                            Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
//                        }
//                        ProductModel productModel = productModels.get(0);
//                        Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//        rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
//        rcvData.setAdapter(new AllDataAdaptor(getContext(), allDataModels));
////        if (allDataModels.isEmpty()){
////            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
////        }
//        searchView = view.findViewById(R.id.searchView);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filterList(newText);
//                return false;
//            }
//        });
        return view;
    }

//    private void filterList(String newText) {
//        filteredList = new ArrayList<>();
//        for (AllDataModel allDataModel : allDataModels){
//            if (allDataModel.getProductName().toLowerCase().contains(newText.toLowerCase())){
//                filteredList.add(allDataModel);
//            }
//
//        }
//        if (filteredList.isEmpty()){
//            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
//            rcvData.setAdapter(new AllDataAdaptor(getContext(), filteredList));
//        }
//    }
//
//    private void getAllData() {
//        allDataModels = new ArrayList<>();
//        allDataModels.clear();
//        if (shopModels.isEmpty()){
//            Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//        }
//        for (ShopModel shopModel:shopModels){
//            String shopName1 = shopModel.getShopName();
//            productModels.clear();
//            db.collection("Shop/"+shopName1+"/Products").addSnapshotListener(new EventListener<QuerySnapshot>() {
//                @Override
//                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                    if(error==null){
//                        List<ProductModel> data = value.toObjects(ProductModel.class);
//                        productModels.addAll(data);
//                        for (ProductModel productModel:productModels){
//                            AllDataModel temp = new AllDataModel(shopModel.getShopName(), shopModel.getShopLocation(), shopModel.getContactNumber(), productModel.getProductName(), productModel.getPrice(), productModel.getQuantity());
//                            allDataModels.add(temp);
//                        }
//                        if (productModels.isEmpty()) {
//                            Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
//                        }
//                        ProductModel productModel = productModels.get(0);
//                        Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
//                        Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }
//        rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
//        rcvData.setAdapter(new AllDataAdaptor(getContext(), allDataModels));
//    }
//
//    public void getShopData(){
//        shopModels = new ArrayList<>();
////        shopName = MainActivity.shopName;
//        db.collection("Shop").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                if(error==null){
//                    List<ShopModel> data = value.toObjects(ShopModel.class);
//                    shopModels.addAll(data);
//                    ShopModel dataModel = shopModels.get(0);
//                    Toast.makeText(getContext(), dataModel.getShopName(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
}
=======
//         rcvData = view.findViewById(R.id.rcvData);
//         db = FirebaseFirestore.getInstance();
//         if (shopModels.isEmpty()){
//             Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//         }
//         db.collection("Shop").addSnapshotListener(new EventListener<QuerySnapshot>() {
//             @Override
//             public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                 if(error==null){
//                     List<ShopModel> data = value.toObjects(ShopModel.class);
//                     shopModels.addAll(data);
//                     ShopModel dataModel = shopModels.get(0);
//                     Toast.makeText(getContext(), dataModel.getShopName(), Toast.LENGTH_SHORT).show();
//                 }
// //                Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//             }
//         });
//         allDataModels = new ArrayList<>();
//         allDataModels.clear();
//         for (ShopModel shopModel:shopModels){
//             String shopName1 = shopModel.getShopName();
//             productModels.clear();
//             db.collection("Shop/"+shopName1+"/Products").addSnapshotListener(new EventListener<QuerySnapshot>() {
//                 @Override
//                 public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                     if(error==null){
//                         List<ProductModel> data = value.toObjects(ProductModel.class);
//                         productModels.addAll(data);
//                         for (ProductModel productModel:productModels){
//                             AllDataModel temp = new AllDataModel(shopModel.getShopName(), shopModel.getShopLocation(), shopModel.getContactNumber(), productModel.getProductName(), productModel.getPrice(), productModel.getQuantity());
//                             allDataModels.add(temp);
//                         }
//                         if (productModels.isEmpty()) {
//                             Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
//                         }
//                         ProductModel productModel = productModels.get(0);
//                         Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                     }
//                     else {
//                         Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                     }
//                 }
//             });
//         }
//         rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
//         rcvData.setAdapter(new AllDataAdaptor(getContext(), allDataModels));
// //        if (allDataModels.isEmpty()){
// //            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
// //        }
//         searchView = view.findViewById(R.id.searchView);
//         searchView.clearFocus();
//         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//             @Override
//             public boolean onQueryTextSubmit(String query) {
//                 return false;
//             }

//             @Override
//             public boolean onQueryTextChange(String newText) {
//                 filterList(newText);
//                 return false;
//             }
//         });
        return view;
    }

//     private void filterList(String newText) {
//         filteredList = new ArrayList<>();
//         for (AllDataModel allDataModel : allDataModels){
//             if (allDataModel.getProductName().toLowerCase().contains(newText.toLowerCase())){
//                 filteredList.add(allDataModel);
//             }

//         }
//         if (filteredList.isEmpty()){
//             Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
//         }
//         else {
//             rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
//             rcvData.setAdapter(new AllDataAdaptor(getContext(), filteredList));
//         }
//     }

//     private void getAllData() {
//         allDataModels = new ArrayList<>();
//         allDataModels.clear();
//         if (shopModels.isEmpty()){
//             Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//         }
//         for (ShopModel shopModel:shopModels){
//             String shopName1 = shopModel.getShopName();
//             productModels.clear();
//             db.collection("Shop/"+shopName1+"/Products").addSnapshotListener(new EventListener<QuerySnapshot>() {
//                 @Override
//                 public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                     if(error==null){
//                         List<ProductModel> data = value.toObjects(ProductModel.class);
//                         productModels.addAll(data);
//                         for (ProductModel productModel:productModels){
//                             AllDataModel temp = new AllDataModel(shopModel.getShopName(), shopModel.getShopLocation(), shopModel.getContactNumber(), productModel.getProductName(), productModel.getPrice(), productModel.getQuantity());
//                             allDataModels.add(temp);
//                         }
//                         if (productModels.isEmpty()) {
//                             Toast.makeText(getContext(), "No data Found", Toast.LENGTH_SHORT).show();
//                         }
//                         ProductModel productModel = productModels.get(0);
//                         Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                     }
//                     else {
//                         Toast.makeText(getContext(), "productModel.getProductName()", Toast.LENGTH_SHORT).show();
//                     }
//                 }
//             });
//         }
//         rcvData.setLayoutManager(new LinearLayoutManager(getContext()));
//         rcvData.setAdapter(new AllDataAdaptor(getContext(), allDataModels));
//     }

//     public void getShopData(){
//         shopModels = new ArrayList<>();
// //        shopName = MainActivity.shopName;
//         db.collection("Shop").addSnapshotListener(new EventListener<QuerySnapshot>() {
//             @Override
//             public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                 if(error==null){
//                     List<ShopModel> data = value.toObjects(ShopModel.class);
//                     shopModels.addAll(data);
//                     ShopModel dataModel = shopModels.get(0);
//                     Toast.makeText(getContext(), dataModel.getShopName(), Toast.LENGTH_SHORT).show();
//                 }
//             }
//         });
//     }
}
>>>>>>> 5c816ef7c7254ea4db96f0febea853a84dfbdb39
