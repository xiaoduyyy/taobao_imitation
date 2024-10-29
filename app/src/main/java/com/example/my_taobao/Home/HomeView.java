package com.example.my_taobao.Home;

import androidx.fragment.app.Fragment;

import com.example.my_taobao.Class.Commodity;

import java.util.List;

public interface HomeView {

    void setupViewPager(List<Fragment> fragmentList, String[] titles);

}
