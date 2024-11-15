package com.example.my_taobao.fragments.mvp;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.my_taobao.base.BasePresenter;
import com.example.my_taobao.Class.Commodity;

import java.util.List;

public class HomePagerPresenter extends BasePresenter<HomePagerModel, HomePagerFragment> {

    @Override
    public HomePagerModel getModelInstance() {
        return new HomePagerModel(this);
    }

    public void loadFragments() {
        List<Fragment> fragments = mModel.getFragments();
        Log.d("HomePagerPresenter", "Fragments loaded: " + fragments.size());
        if (getmView() != null) {
            getmView().setupViewPager(fragments);
        }
    }

    public void loadRecyclerView() {
        List<Commodity> commodities = mModel.getCommodities();

        if (getmView() != null) {
            getmView().setupRecyclerView(commodities);
        }
    }
}
