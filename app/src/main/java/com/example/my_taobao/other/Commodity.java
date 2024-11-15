package com.example.my_taobao.other;

import java.util.List;

public class Commodity {

    private int commodityImage;

    private String commodityText;

    private String commodityDecrase;

    private boolean isSelected;

    private String commodityPrice;

    private String commoditySell;

    private List<Integer> images;

    private int quantity;

    private int longImage1;

    private int longImage2;


    public Commodity(int commodityImage, String commodityText, String commodityDecrase, String commodityPrice, String commoditySell, List<Integer> images, int longImage1, int longImage2) {
        this.commodityImage = commodityImage;
        this.commodityText = commodityText;
        this.commodityDecrase = commodityDecrase;
        this.isSelected = false;
        this.commodityPrice = commodityPrice;
        this.commoditySell = commoditySell;
        this.images = images;
        this.quantity = 1;
        this.longImage1 = longImage1;
        this.longImage2 = longImage2;
    }

    public int getLongImage1() {
        return longImage1;
    }

    public void setLongImage1(int longImage1) {
        this.longImage1 = longImage1;
    }

    public int getLongImage2() {
        return longImage2;
    }

    public void setLongImage2(int longImage2) {
        this.longImage2 = longImage2;
    }

    public Commodity() {
    }



    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }





    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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


}
