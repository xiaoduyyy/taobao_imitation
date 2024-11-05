package com.example.my_taobao.Mine;

import com.example.my_taobao.Base.BasePresenter;
import com.example.my_taobao.Class.Commodity;

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
