package com.example.pascalisnala.cleart.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pascalisnala.cleart.API.retrofitClient;
import com.example.pascalisnala.cleart.R;
import com.example.pascalisnala.cleart.models.defaultResponse;
import com.example.pascalisnala.cleart.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {


    private EditText etName, etUsername, etEmail, etPhonenum, etPassword, etRepeatpass;
    private Button btnContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etName = findViewById(R.id.tvHome);
        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPhonenum = findViewById(R.id.etPhonenum);
        etPassword = findViewById(R.id.etPassword);
        etRepeatpass = findViewById(R.id.etRepeatpass);

        btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userSignup();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (SharedPrefManager.getInstance(this).isLoggedin()) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userSignup() {
        String name = etName.getText().toString().trim();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phonenum = etPhonenum.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String repeatpass = etRepeatpass.getText().toString().trim();

        if (name.isEmpty()) {
            etName.setError("Name Field Required");
            etName.requestFocus();
            return;
        }

        if (username.isEmpty()) {
            etUsername.setError("Username Field Required");
            etUsername.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email Field Required");
            etEmail.requestFocus();
            return;
        }

        if (phonenum.isEmpty()) {
            etPhonenum.setError("Please Fill With Your Phone Number");
            etPhonenum.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("password field required");
            etPassword.requestFocus();
            return;
        }

        if (repeatpass.isEmpty()) {
            etRepeatpass.setError("please repeat password");
            etRepeatpass.requestFocus();
            return;
        }

        if (!repeatpass.equals(password)) {
            etRepeatpass.setError("password not match ");
            etRepeatpass.requestFocus();
            return;
        }

        Call<defaultResponse> call = retrofitClient
                .getInstance()
                .getApi()
                .createUser(name, username, email, phonenum, password);

        call.enqueue(new Callback<defaultResponse>() {
            @Override
            public void onResponse(Call<defaultResponse> call, Response<defaultResponse> response) {
                if (response.code() == 201) {
                    defaultResponse dr = response.body();
                    Toast.makeText(SignupActivity.this, dr.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    //defaultResponse dr = response.errorBody();
                    Toast.makeText(SignupActivity.this, "User Already Exist   ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<defaultResponse> call, Throwable t) {

            }
        });


    }
}
