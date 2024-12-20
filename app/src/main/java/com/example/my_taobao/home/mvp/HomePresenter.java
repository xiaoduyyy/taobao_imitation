package com.example.my_taobao.home.mvp;

import com.example.my_taobao.base.BasePresenter;

import java.util.List;
import androidx.fragment.app.Fragment;

public class HomePresenter extends BasePresenter<HomeModel, HomeFragment> {

    @Override
    public HomeModel getModelInstance() {
        return new HomeModel(this);
    }

    public void loadFragments() {
        List<Fragment> fragmentList = mModel.getFragmentList();
        String[] titles = mModel.getTitles();

        if (getmView() != null) {
            getmView().setupViewPager(fragmentList, titles);
        }
    }
}
