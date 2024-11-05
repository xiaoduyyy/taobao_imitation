package com.example.my_taobao.Class;

import android.widget.ImageView;
import android.widget.TextView;

public class Commodity {

    private int commodityImage;

    private String commodityText;

    private String commodityDecrase;

    private String commodityPrice;

    private String commoditySell;

    public String getCommodityDecrase() {
        return commodityDecrase;
    }

    public void setCommodityDecrase(String commodityDecrase) {
        this.commodityDecrase = commodityDecrase;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommoditySell() {
        return commoditySell;
    }

    public void setCommoditySell(String commoditySell) {
        this.commoditySell = commoditySell;
    }

    public Commodity() {
    }

    public Commodity(int commodityImage, String commodityText, String commodityDecrase, String commodityPrice, String commoditySell) {
        this.commodityImage = commodityImage;
        this.commodityText = commodityText;
        this.commodityDecrase = commodityDecrase;
        this.commodityPrice = commodityPrice;
        this.commoditySell = commoditySell;
    }

    public int getCommodityImage() {
        return commodityImage;
    }

    public void setCommodityImage(int commodityImage) {
        this.commodityImage = commodityImage;
    }

    public String getCommodityText() {
        return commodityText;
    }

    public void setCommodityText(String commodityText) {
        this.commodityText = commodityText;
    }
}
