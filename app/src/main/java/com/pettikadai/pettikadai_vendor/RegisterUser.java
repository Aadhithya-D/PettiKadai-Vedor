package com.pettikadai.pettikadai_vendor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterUser extends AppCompatActivity {
    Button submit;
    EditText name, loc, num, email, password;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        name = findViewById(R.id.reg_shop_name);
        loc = findViewById(R.id.reg_loc);
        num = findViewById(R.id.reg_num);
        email = findViewById(R.id.regEmail);
        password = findViewById(R.id.reg_password);
        submit = findViewById(R.id.submit);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = name.getText().toString();
                String locStr = loc.getText().toString();
                long conNum = Long.parseLong(num.getText().toString());
                String emailStr = email.getText().toString();
                String pass = password.getText().toString();
                ShopModel data = new ShopModel(nameStr, locStr, conNum);
                mAuth.createUserWithEmailAndPassword(emailStr, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            db.collection("Shop").document(nameStr).set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(RegisterUser.this, "Shop created", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(RegisterUser.this, MainActivity.class);
                                        intent.putExtra("Name", nameStr);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(RegisterUser.this, "Error!!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });

    }
}
