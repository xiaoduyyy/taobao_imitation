package com.example.my_taobao.custom;

import com.example.my_taobao.other.Commodity;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<Commodity> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addCommodity(Commodity commodity) {
        cartItems.add(commodity);
    }

    public Commodity getCommodityById(String text) {
        for (Commodity commodity : cartItems) {
            if (commodity.getCommodityText().equals(text)) {  // 根据商品ID匹配
                return commodity;
            }
        }
        return null;
    }

    public boolean isCommodityInCart(Commodity commodity) {
        for (Commodity item : cartItems) {
            if (item.getCommodityText().equals(commodity.getCommodityText())) {
                return true;
            }
        }
        return false;
    }

    public List<Commodity> getCartItems() {
        return cartItems;
    }

    public void removeCommodity(Commodity commodity) {
        cartItems.remove(commodity);
    }

    public void removeAllSelectedCommodities(List<Commodity> commodities) {
        cartItems.removeAll(commodities);
    }

    public void clearCart() {
        cartItems.clear();
    }
}
