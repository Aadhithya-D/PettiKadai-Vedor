package com.pettikadai.pettikadai_vendor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

public class Product extends AppCompatActivity {
    Button submit;
    EditText proName, price, quantity;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        submit = findViewById(R.id.product_submit);
        proName = findViewById(R.id.product_name);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        db = FirebaseFirestore.getInstance();
        String shopName = getIntent().getStringExtra("Name");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String proNameStr = proName.getText().toString();
                int priceInt = Integer.parseInt(price.getText().toString());
                int quantityInt = Integer.parseInt(quantity.getText().toString());

                ProductModel data = new ProductModel(proNameStr, priceInt, quantityInt);

                db.collection("Shop/"+shopName+"/Products").document(proNameStr).set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Product.this, "Product added", Toast.LENGTH_LONG).show();
                            proName.setText("");
                            price.setText("");
                            quantity.setText("");
                        }
                        else{
                            Toast.makeText(Product.this, "Error!!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent= new Intent(Product.this,MainActivity.class);
        startActivity(intent);
    }
}
