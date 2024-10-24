package com.example.my_taobao.Base;

public abstract class BasePresenter<M extends BaseModel, V extends BaseFragment> {

    public V mView;

    public M mModel;

    public BasePresenter() {
        this.mModel = getModelInstance();
    }

    public void bindView(V view) {
        this.mView = view;
    }

    public void unBindView() {
        this.mView = null;
    }

    public abstract M getModelInstance();
}
