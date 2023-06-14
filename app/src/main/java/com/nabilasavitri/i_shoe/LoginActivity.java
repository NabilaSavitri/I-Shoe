package com.nabilasavitri.i_shoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.nabilasavitri.i_shoe.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUsername.getText().toString();
                String password = binding.etPassword.getText().toString();

                Boolean bolehLogin = true;
                if (TextUtils.isEmpty(username)) {
                    bolehLogin = false;
                    binding.etUsername.setError("Username tida boleh kosong!");
                }

                if (TextUtils.isEmpty(password)) {
                    bolehLogin = false;
                    binding.etPassword.setError("Password tidak boleh kosong!");
                }

                if (bolehLogin) {
                    login(username, password); {

                    }
                }
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void login(String username, String password) {
        binding.progressBar.setVisibility(View.VISIBLE);
        Toast.makeText(LoginActivity.this, "Login success!", Toast.LENGTH_SHORT).show();
        Utilities.setValue(LoginActivity.this, "xUsername", username);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        binding.progressBar.setVisibility(View.GONE);
    }
}
