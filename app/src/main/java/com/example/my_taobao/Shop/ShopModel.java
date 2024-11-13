package com.example.my_taobao.Shop;

import com.example.my_taobao.Base.BaseModel;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.Custom.CartManager;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopModel extends BaseModel<ShopPresenter> {

    private static CartManager cartManager ;

    public ShopModel(ShopPresenter presenter) {
        super(presenter);
        cartManager  = CartManager.getInstance();
    }

    public List<Commodity> getCommodites() {
        return cartManager.getCartItems();
    }

    public void deleteCommodities(List<Commodity> toRemove) {
        cartManager.removeAllSelectedCommodities(toRemove);
        mPresenter.updateViewAfterDeletion();
    }
}
