package com.example.my_taobao.home.mvp;

import com.example.my_taobao.base.BaseModel;
import com.example.my_taobao.fragments.mvp.HomePagerFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class HomeModel extends BaseModel<HomePresenter> {

    public HomeModel(HomePresenter presenter) {
        super(presenter);
    }

    public List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomePagerFragment());
        fragmentList.add(new HomePagerFragment());
        fragmentList.add(new HomePagerFragment());
        fragmentList.add(new HomePagerFragment());
        fragmentList.add(new HomePagerFragment());
        fragmentList.add(new HomePagerFragment());
        return fragmentList;
    }

    public String[] getTitles() {
        return new String[]{"关注", "推荐", "美食", "居家", "运动", "户外"};
    }


}
