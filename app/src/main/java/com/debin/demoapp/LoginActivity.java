package com.debin.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.debin.demoapp.data.FakeServer;

public class LoginActivity extends AppCompatActivity {


    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;
    private ProgressBar progressBar;
    private static final String TAG = "LoginActivity";
    FakeServer fakeServer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_login);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        progressBar = findViewById(R.id.pb_login);
        fakeServer = getIntent().getParcelableExtra(getString(R.string.FAKESERVER));
        etUsername.setText(fakeServer.getUserName());
        etPassword.setText(fakeServer.getPassword());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().trim().isEmpty() ||
                        !etUsername.getText().toString().trim().equals(fakeServer.getUserName())) {
                   etUsername.setError("Please enter valid user name");
                } else if(etPassword.getText().toString().trim().isEmpty() ||
                         !etPassword.getText().toString().equals(fakeServer.getPassword())) {
                  etUsername.setError("Please enter valid password");
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    Intent toWelcomeActivity = new Intent(LoginActivity.this, WelcomeActivity.class);
                    toWelcomeActivity.putExtra(getString(R.string.FAKESERVER), fakeServer);
                    startActivity(toWelcomeActivity);
                    finish();
                }
            }
        });
    }
}
