package com.example.my_taobao.Shop;

import com.example.my_taobao.Base.BasePresenter;

public class ShopPresenter extends BasePresenter<ShopModel, ShopFragment> {
    @Override
    public ShopModel getModelInstance() {
        return new ShopModel(this);
    }
}
