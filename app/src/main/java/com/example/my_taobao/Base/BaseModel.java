package com.example.my_taobao.Base;

public class BaseModel<P extends BasePresenter>{
    public P mPresenter;

    public BaseModel(P presenter) {
        this.mPresenter = presenter;
    }
}
