package com.example.my_taobao.Base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    public P mPresenter;

    protected View mView;
    protected Activity mActivity;
    protected Context mContext;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenterInstance();
        mPresenter.bindView(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unBindView();
    }

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract int getLayoutId();

    public abstract P getPresenterInstance();

}