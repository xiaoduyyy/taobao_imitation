package com.example.my_taobao.home;

import com.example.my_taobao.Base.BaseFragment;
import com.example.my_taobao.R;

public class HomeFragment extends BaseFragment<HomePresenter> {


    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public HomePresenter getPresenterInstance() {
        return new HomePresenter();
    }
}
