package com.pettikadai.pettikadai_vendor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.pettikadai.pettikadai_vendor.databinding.ActivityMainBinding;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public static String shopName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        shopName = getIntent().getStringExtra("Name");
//        sendDataProductFragment();
        replaceFragment(new ProductFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.add:
                    replaceFragment(new ProductFragment());
                    break;
                case R.id.view:
                    replaceFragment(new ProductViewFragment());
                    break;
                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;
            }
            return true;
        });
    }

    private void sendDataProductFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("ShopName", shopName);
        ProductFragment productFragment = new ProductFragment();
        productFragment.setArguments(bundle);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

//    public void getData (){
//        mPhotos = new ArrayList<>();
//        mPhotos.clear();
//        db.collection("Shop").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                if(error==null){
//                    List<ShopModel> data = value.toObjects(ShopModel.class);
//                    mPhotos.addAll(data);
//                    rcvData.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                    rcvData.setAdapter(new ReadDataAdaptor(MainActivity.this, mPhotos));
//                    ShopModel temp = mPhotos.get(0);
//                    Toast.makeText(MainActivity.this, temp.shopName, Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
}