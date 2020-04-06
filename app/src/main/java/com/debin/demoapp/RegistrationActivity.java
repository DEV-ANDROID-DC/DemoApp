package com.debin.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.debin.demoapp.data.FakeServer;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {

    private  Button btnRegister;
    private TextInputEditText etUsername;
    private TextInputEditText etPassword;
    private TextInputEditText etConfirmPassword;
    private ProgressBar progressBar;
    FakeServer fakeServer = new FakeServer();

    private static final String TAG = "RegistrationActivity";
    //Add splash screen and progress bar on button clicks
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnRegister = findViewById(R.id.brn_register);
        progressBar = findViewById(R.id.pb_registration);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Objects.requireNonNull(etUsername.getText()).toString().trim().isEmpty() &&
                        !Objects.requireNonNull(etPassword.getText()).toString().isEmpty() &&
                        etPassword.getText().toString().equals(etConfirmPassword.getText().toString()) &&
                        etPassword.getText().toString().length()>4) {
                        progressBar.setVisibility(View.VISIBLE);
                         startActivityLogin();
                } else if (etUsername.getText().toString().trim().isEmpty()){
                    etUsername.setError("User name required");
                } else if (etPassword.getText().toString().trim().length()<4) {
                    etPassword.setError("Please enter password with minimum 5 characters");
                } else if(!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
                    etConfirmPassword.setError("Password Mismatch");
                } else if(etPassword.getText().toString().trim().isEmpty() ||
                        etConfirmPassword.getText().toString().trim().isEmpty()) {
                    etPassword.setError("Password required");
                }
            }
        });

        etConfirmPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if((event!=null) && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)||
                        (actionId == EditorInfo.IME_ACTION_DONE)) {
                   btnRegister.performClick();
                }
                return false;
            }
        });

    }

    public void startActivityLogin() {
        String userName = etUsername.getText().toString().trim();
        String password = Objects.requireNonNull(etPassword.getText()).toString().trim();
        fakeServer.registerUser(userName,password);
        Log.i(TAG, "Username ::" +fakeServer.getUserName());
        Log.i(TAG, "password ::" +fakeServer.getPassword());
        Intent toLogin = new Intent(RegistrationActivity.this, LoginActivity.class);
        toLogin.putExtra(getString(R.string.FAKESERVER), fakeServer);
        startActivity(toLogin);
        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
