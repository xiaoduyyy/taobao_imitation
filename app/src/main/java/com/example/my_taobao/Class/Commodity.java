package com.example.my_taobao.Class;

import android.widget.ImageView;
import android.widget.TextView;

public class Commodity {

    private int commodityImage;

    private String commodityText;

    public Commodity() {
    }

    public Commodity(int commodityImage, String commodityText) {
        this.commodityImage = commodityImage;
        this.commodityText = commodityText;
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
