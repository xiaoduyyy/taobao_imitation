package com.example.my_taobao.Class;

import java.util.ArrayList;
import java.util.List;

public class Commodity {

    private int commodityImage;

    private String commodityText;

    private String commodityDecrase;

    private String commodityPrice;

    private String commoditySell;

    private List<Integer> images;

    public Commodity() {
    }

    public Commodity(int commodityImage, String commodityText, String commodityDecrase, String commodityPrice, String commoditySell, List<Integer> images) {
        this.commodityImage = commodityImage;
        this.commodityText = commodityText;
        this.commodityDecrase = commodityDecrase;
        this.commodityPrice = commodityPrice;
        this.commoditySell = commoditySell;
        this.images = images;
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

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

    @Override
    public String toString() {
        return "Commodity{" +
                "commodityImage=" + commodityImage +
                ", commodityText='" + commodityText + '\'' +
                ", commodityDecrase='" + commodityDecrase + '\'' +
                ", commodityPrice='" + commodityPrice + '\'' +
                ", commoditySell='" + commoditySell + '\'' +
                ", images=" + images +
                '}';
    }
}
