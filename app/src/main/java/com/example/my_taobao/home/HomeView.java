package com.example.my_taobao.home;

import androidx.fragment.app.Fragment;

import java.util.List;

public interface HomeView {

    void setupViewPager(List<Fragment> fragmentList, String[] titles);

}
