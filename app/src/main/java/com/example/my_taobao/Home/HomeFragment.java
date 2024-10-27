package com.example.my_taobao.Home;

import android.os.Handler;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.my_taobao.Adapters.FragmentAdapter;
import com.example.my_taobao.Base.BaseFragment;
import com.example.my_taobao.Fragments.HomePagerFragment;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> {

    private SwipeRefreshLayout swipeRefreshLayout;
    private Handler handler;
    private ViewPager2 viewPager;
    private List<Fragment> fragmentList;
    private FragmentAdapter fragmentAdapter;
    private String[] titles;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        swipeRefreshLayout = view.findViewById(R.id.swiprefreshlayout_home);
        viewPager = view.findViewById(R.id.view_pager);


        swipeRefreshLayout.setRefreshing(false);

        handler = new Handler();

        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(true);

            handler.postDelayed(() -> {
                swipeRefreshLayout.setRefreshing(false);
            }, 1000);
        });

        initData();
        fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), getLifecycle(), titles, fragmentList);
        viewPager.setAdapter(fragmentAdapter);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public HomePresenter getPresenterInstance() {
        return new HomePresenter();
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomePagerFragment());
        fragmentList.add(new HomePagerFragment());
        fragmentList.add(new HomePagerFragment());
        titles = new String[]{"1", "2", "3"};
    }
}
