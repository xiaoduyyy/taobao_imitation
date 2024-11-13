package com.example.my_taobao.Home.mvp;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.my_taobao.Adapters.FragmentAdapter;
import com.example.my_taobao.Base.BaseFragment;
import com.example.my_taobao.Custom.MyRecyclerView;
import com.example.my_taobao.Home.HomeView;
import com.example.my_taobao.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private FragmentAdapter fragmentAdapter;
    private Handler handler;

    @Override
    protected void initListener() {
        handler = new Handler();
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(true);
            handler.postDelayed(() -> swipeRefreshLayout.setRefreshing(false), 1000);
        });
        swipeRefreshLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    if (event.getY() > 100) {
                        swipeRefreshLayout.setEnabled(false);
                    } else {
                        swipeRefreshLayout.setEnabled(true);
                    }
                }
                return false;
            }
        });
        viewPager.setOnTouchListener((v, event) -> true); // 禁用滑动
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView tabTextView = (TextView) tab.getCustomView();
                if (tabTextView != null) {
                    tabTextView.setTextSize(30);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView tabTextView = (TextView) tab.getCustomView();
                if (tabTextView != null) {
                    tabTextView.setTextSize(16);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                TextView tabTextView = (TextView) tab.getCustomView();
                if (tabTextView != null) {
                    tabTextView.setTextSize(30);
                }
            }
        });
    }

    @Override
    protected void initView(View view) {
        swipeRefreshLayout = view.findViewById(R.id.swiprefreshlayout_home);
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab_layout);

        // 初始化数据，通过Presenter获取数据
        mPresenter.loadFragments();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public HomePresenter getPresenterInstance() {
        return new HomePresenter();
    }

    // 更新ViewPager的数据
    public void setupViewPager(List<Fragment> fragmentList, String[] titles) {
        fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), getLifecycle(), titles, fragmentList);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOffscreenPageLimit(fragmentList.size());
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(titles[0]);
                    break;
                case 1:
                    tab.setText(titles[1]);
                    break;
                case 2:
                    tab.setText(titles[2]);
                    break;
                case 3:
                    tab.setText(titles[3]);
                    break;
                case 4:
                    tab.setText(titles[4]);
                    break;
                case 5:
                    tab.setText(titles[5]);
                    break;
                default:
                    break;
            }
        }).attach();
    }


}
