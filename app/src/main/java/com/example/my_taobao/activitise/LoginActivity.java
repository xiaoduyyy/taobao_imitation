package com.example.my_taobao.activitise;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_taobao.MainActivity;
import com.example.my_taobao.R;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText text;
    private TextView register, terms;
    private Button cancelBUtton;
    private SpannableString spannableString;
    private ClickableSpan clickableSpan1, clickableSpan2, clickableSpan3;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        register = findViewById(R.id.register);
        loginButton = findViewById(R.id.commitLogin_button);
        text = findViewById(R.id.account_text);
        cancelBUtton = findViewById(R.id.cancel);
        terms = findViewById(R.id.login_text);
        agree = findViewById(R.id.agree_terms);

        loginButton.setEnabled(false);
        String text1 = terms.getText().toString();
        spannableString = new SpannableString(text1);

        clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                intent = new Intent(LoginActivity.this, WebViewActivity.class);
                intent.putExtra("string", "https://terms.alicdn.com/legal-agreement/terms/TD/TD201609301342_19559.html");
                startActivity(intent);
            }
        };

        clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                intent = new Intent(LoginActivity.this, WebViewActivity.class);
                intent.putExtra("string", "https://terms.alicdn.com/legal-agreement/terms/suit_bu1_taobao/suit_bu1_taobao201703241622_61002.html");
                startActivity(intent);
            }
        };

        clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                intent = new Intent(LoginActivity.this, WebViewActivity.class);
                intent.putExtra("string", "https://www.taobao.com/go/chn/member/alipay_agreement.php");
                startActivity(intent);
            }
        };

        spannableString.setSpan(clickableSpan1, 11, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan2, 21, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan3, 28, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        terms.setText(spannableString);
        terms.setMovementMethod(LinkMovementMethod.getInstance());

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
