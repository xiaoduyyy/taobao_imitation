package com.example.my_taobao.activitise;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_taobao.R;

public class CoverActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cover_activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(CoverActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }
}
