package com.example.my_taobao.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.my_taobao.Base.SimpleActivity;
import com.example.my_taobao.R;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends SimpleActivity {

    private Banner banner;
    private List<Integer> bannerData;

    private TextView price;
    private TextView text;
    private TextView addToCart;
    private TextView buyNow;

    private Intent intent;
    private Button button;
    @Override
    protected int getLayoutId() {
        return R.layout.pruduct_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        banner = findViewById(R.id.product_banner);
        price = findViewById(R.id.product_price);
        text = findViewById(R.id.product_text);
        addToCart = findViewById(R.id.commodity_add_to_cart);
        buyNow = findViewById(R.id.commodity_buy_now);
        button = findViewById(R.id.back_button);
        intent = getIntent();

        bannerData = intent.getIntegerArrayListExtra("images");
        text.setText(intent.getStringExtra("text"));
        price.setText(intent.getStringExtra("price"));


        banner.setAdapter(new BannerImageAdapter<Integer>(bannerData) {

            @Override
            public void onBindView(BannerImageHolder holder, Integer data, int position, int size) {
                holder.imageView.setImageResource(data);
            }
        });
        banner.isAutoLoop(true);

    }

    @Override
    protected void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
