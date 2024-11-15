package com.example.my_taobao.activitise;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_taobao.R;

public class RegisterActivity extends AppCompatActivity {

    private Button register;
    private EditText account;
    private EditText password;
    private Button cancel;
    private SpannableString spannableString;
    private ClickableSpan clickableSpan1, clickableSpan2, clickableSpan3, clickableSpan4;
    private TextView terms;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        register = findViewById(R.id.register_rightnow);
        account = findViewById(R.id.account_register);
        password = findViewById(R.id.password_register);
        cancel = findViewById(R.id.cancel_register);
        terms = findViewById(R.id.register_text);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String text1 = terms.getText().toString();
        spannableString = new SpannableString(text1);

        clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                intent = new Intent(RegisterActivity.this, WebViewActivity.class);
                intent.putExtra("string", "https://terms.alicdn.com/legal-agreement/terms/TD/TD201609301342_19559.html");
                startActivity(intent);
            }
        };

        clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                intent = new Intent(RegisterActivity.this, WebViewActivity.class);
                intent.putExtra("string", "https://terms.alicdn.com/legal-agreement/terms/suit_bu1_taobao/suit_bu1_taobao201703241622_61002.html");
                startActivity(intent);
            }
        };

        clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                intent = new Intent(RegisterActivity.this, WebViewActivity.class);
                intent.putExtra("string", "https://www.taobao.com/go/chn/member/alipay_agreement.php");
                startActivity(intent);
            }
        };

        clickableSpan4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                intent = new Intent(RegisterActivity.this, WebViewActivity.class);
                intent.putExtra("string", "https://e.189.cn/_agreements.html");
                startActivity(intent);
            }
        };

        spannableString.setSpan(clickableSpan1, 11, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan2, 21, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan3, 28, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan4, 39, 51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        terms.setText(spannableString);
        terms.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
