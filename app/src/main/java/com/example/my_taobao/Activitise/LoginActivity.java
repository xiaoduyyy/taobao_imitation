package com.example.my_taobao.Activitise;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_taobao.MainActivity;
import com.example.my_taobao.R;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText text;
    private TextView register;
    private Button cancelBUtton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        register = findViewById(R.id.register);
        loginButton = findViewById(R.id.commitLogin_button);
        text = findViewById(R.id.account_text);
        cancelBUtton = findViewById(R.id.cancel);

        loginButton.setEnabled(false);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                loginButton.setBackgroundResource(R.drawable.login_button_unselected);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    loginButton.setEnabled(false);
                    loginButton.setBackgroundResource(R.drawable.login_button_unselected);
                } else {
                    loginButton.setEnabled(true);
                    loginButton.setBackgroundResource(R.drawable.login_button);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().isEmpty()) {
                    loginButton.setEnabled(false);
                    loginButton.setBackgroundResource(R.drawable.login_button_unselected);
                } else {
                    loginButton.setEnabled(true);
                    loginButton.setBackgroundResource(R.drawable.login_button);
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        cancelBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
