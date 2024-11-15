package com.example.my_taobao.shop;

import com.example.my_taobao.base.BaseModel;
import com.example.my_taobao.other.Commodity;
import com.example.my_taobao.custom.CartManager;

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
