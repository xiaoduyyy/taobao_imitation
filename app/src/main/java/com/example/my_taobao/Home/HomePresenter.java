package com.example.my_taobao.Home;

import com.example.my_taobao.Base.BasePresenter;

public class HomePresenter extends BasePresenter<HomeModel, HomeFragment> {

    @Override
    public HomeModel getModelInstance() {
        return new HomeModel(this);
    }

}
