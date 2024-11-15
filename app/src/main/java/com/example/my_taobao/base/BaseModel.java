package com.example.my_taobao.base;

public class BaseModel<P extends BasePresenter>{
    public P mPresenter;

    public BaseModel(P presenter) {
        this.mPresenter = presenter;
    }
}
