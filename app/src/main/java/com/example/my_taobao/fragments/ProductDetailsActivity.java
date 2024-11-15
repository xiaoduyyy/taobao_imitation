package com.example.my_taobao.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import com.example.my_taobao.base.SimpleActivity;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.custom.CartManager;
import com.example.my_taobao.R;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

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
    private Button button, buttonBack;

    private Commodity commodity;
    private List<Commodity> commodities;

    private static CartManager cartManager;

    private ImageView imageView1, imageView2;

    private Toolbar toolbar;

    private NestedScrollView scrollView;

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
        buttonBack = findViewById(R.id.back_button_hide);
        imageView1 = findViewById(R.id.product_longImage_one);
        imageView2 = findViewById(R.id.product_longImage_two);
        scrollView = findViewById(R.id.nestedScrollView);
        toolbar = findViewById(R.id.details_toolbar);

        intent = getIntent();


        ArrayList<Integer> images = intent.getIntegerArrayListExtra("images");
        String text1 = intent.getStringExtra("text");
        String decrase = intent.getStringExtra("priceDecrase");
        String price1 = intent.getStringExtra("price");
        String sell = intent.getStringExtra("sell");
        int longImage1 = intent.getIntExtra("longimage1", R.drawable.chouzhichang1);
        int longImage2 = intent.getIntExtra("longimage2", R.drawable.chouzhichang1);

        cartManager = CartManager.getInstance();
        commodities = cartManager.getCartItems();
        commodity = new Commodity(images.get(0), text1, decrase, price1, sell, images, longImage1, longImage2);

        bannerData = images;
        text.setText(text1);
        price.setText(price1);
        imageView1.setImageResource(longImage1);
        imageView2.setImageResource(longImage2);


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

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Commodity commodity1 = commodity;
                if (cartManager.isCommodityInCart(commodity)) {
                    Commodity existingCommodity = cartManager.getCommodityById(commodity.getCommodityText());
                    existingCommodity.setQuantity(existingCommodity.getQuantity() + 1);
                } else {
                    cartManager.addCommodity(commodity);
                }
                Toast.makeText(ProductDetailsActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 600) {
                    if (toolbar.getVisibility() != View.VISIBLE) {
                        toolbar.setVisibility(View.VISIBLE);
                    }
                } else {
                    if (toolbar.getVisibility() != View.GONE) {
                        toolbar.setVisibility(View.GONE);
                    }
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
