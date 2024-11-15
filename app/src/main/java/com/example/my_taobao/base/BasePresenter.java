package com.example.my_taobao.base;

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

    public V getmView() {
        return mView;
    }

    public void setmView(V mView) {
        this.mView = mView;
    }

    public M getmModel() {
        return mModel;
    }

    public void setmModel(M mModel) {
        this.mModel = mModel;
    }
}
