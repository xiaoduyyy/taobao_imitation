package com.example.my_taobao.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my_taobao.Base.SimpleActivity;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.Custom.CartManager;
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
    private Button button;

    private Commodity commodity;
    private List<Commodity> commodities;

    private static CartManager cartManager;

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


        ArrayList<Integer> images = intent.getIntegerArrayListExtra("images");
        String text1 = intent.getStringExtra("text");
        String decrase = intent.getStringExtra("priceDecrase");
        String price1 = intent.getStringExtra("price");
        String sell = intent.getStringExtra("sell");

        cartManager = CartManager.getInstance();
        commodities = cartManager.getCartItems();
        commodity = new Commodity(images.get(0), text1, decrase, price1, sell, images);

        bannerData = images;
        text.setText(text1);
        price.setText(price1);


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
    }
}
