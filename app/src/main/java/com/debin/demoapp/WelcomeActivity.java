package com.debin.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.debin.demoapp.data.FakeServer;

public class WelcomeActivity extends AppCompatActivity {

    private TextView textView;
    FakeServer fakeServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textView = findViewById(R.id.tv_name);
        fakeServer = getIntent().getParcelableExtra(getString(R.string.FAKESERVER));
        textView.setText("Welcome " +fakeServer.getUserName());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent exit = new Intent((Intent.ACTION_MAIN));
//        exit.addCategory(Intent.CATEGORY_HOME);
//        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(exit);
    }
}
