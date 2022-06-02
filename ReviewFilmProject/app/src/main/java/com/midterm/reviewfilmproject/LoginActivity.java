package com.midterm.reviewfilmproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.midterm.reviewfilmproject.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
         binding.btnlogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (TextUtils.isEmpty(binding.inputEmail.getText().toString()) || TextUtils.isEmpty(binding.inputPassword.getText().toString())){
                     Toast.makeText(LoginActivity.this, "All fileds are required", Toast.LENGTH_SHORT).show();
                 } else {

                     auth.signInWithEmailAndPassword(binding.inputEmail.getText().toString() , binding.inputPassword.getText().toString())
                             .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                     if (task.isSuccessful()) {
                                         Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
                                         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                         startActivity(intent);
                                         finish();
                                     } else {
                                         Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                                     }
                                 }
                             });
             }
             }
         });
        binding.textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
