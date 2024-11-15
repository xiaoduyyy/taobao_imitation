package com.example.my_taobao.shop;

import com.example.my_taobao.base.BasePresenter;
import com.example.my_taobao.Class.Commodity;

import java.util.List;

public class ShopPresenter extends BasePresenter<ShopModel, ShopFragment> {
    @Override
    public ShopModel getModelInstance() {
        return new ShopModel(this);
    }

    public void loadItems() {
        List<Commodity> commodities = mModel.getCommodites();
        if (commodities != null) {
            mView.setupRecyclerView(commodities);
        }
    }

    public void removeSelectedCommodities(List<Commodity> toRemove) {
        mModel.deleteCommodities(toRemove);
    }

    public void updateViewAfterDeletion() {
        mView.updateViewAfterDeletion();
    }
}
