package com.example.my_taobao.activitise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_taobao.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private Intent intent;
    private Button back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        back = findViewById(R.id.webview_back);
        intent = getIntent();

        webView = findViewById(R.id.webview);
        String string = intent.getStringExtra("string");
        webView.loadUrl(string);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
