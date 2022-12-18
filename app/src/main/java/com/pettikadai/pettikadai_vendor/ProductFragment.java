package com.pettikadai.pettikadai_vendor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class ProductFragment extends Fragment {
    EditText name, price, quantity;
    Button submit;
    FirebaseFirestore db;
     String shopName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, container, false);
        shopName = MainActivity.shopName;
        name = v.findViewById(R.id.product_name);
        price = v.findViewById(R.id.price);
        quantity = v.findViewById(R.id.quantity);
        submit = v.findViewById(R.id.product_submit);
        db = FirebaseFirestore.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proNameStr = name.getText().toString();
                int priceInt = Integer.parseInt(price.getText().toString());
                int quantityInt = Integer.parseInt(quantity.getText().toString());

                ProductModel data = new ProductModel(proNameStr, priceInt, quantityInt);

                db.collection("Shop/"+shopName+"/Products").document(proNameStr).set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            name.setText("");
                            price.setText("");
                            quantity.setText("");
                            Toast.makeText(getContext(), "Product Added", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return v;
    }

}