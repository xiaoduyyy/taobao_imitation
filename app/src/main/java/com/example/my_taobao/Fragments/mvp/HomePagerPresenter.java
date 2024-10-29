package com.example.my_taobao.Fragments.mvp;

import com.example.my_taobao.Base.BasePresenter;
import com.example.my_taobao.Class.Commodity;

import java.util.List;

public class HomePagerPresenter extends BasePresenter<HomePagerModel, HomePagerFragment> {

    @Override
    public HomePagerModel getModelInstance() {
        return new HomePagerModel(this);
    }

    public void loadRecyclerView() {
        List<Commodity> commodities = mModel.getCommodities();

        if (getmView() != null) {
            getmView().setupRecyclerView(commodities);
        }
    }
}
