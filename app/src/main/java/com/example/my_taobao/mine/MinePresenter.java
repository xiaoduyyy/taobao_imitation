package com.example.my_taobao.mine;

import com.example.my_taobao.base.BasePresenter;
import com.example.my_taobao.other.Commodity;

import java.util.List;

public class MinePresenter extends BasePresenter<MineModel, MineFragment> {
    @Override
    public MineModel getModelInstance() {
        return new MineModel(this);
    }

    public void loadRecyclerView() {
        List<Commodity> commodities = mModel.getCommodities();

        if (getmView() != null) {
            getmView().setupRecyclerView(commodities);
        }
    }
}
