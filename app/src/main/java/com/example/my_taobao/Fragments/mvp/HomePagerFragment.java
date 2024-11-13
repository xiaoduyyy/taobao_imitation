package com.example.my_taobao.Fragments.mvp;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.my_taobao.Adapters.PicturesFragmentAdapter;
import com.example.my_taobao.Custom.MyViewPager;
import com.example.my_taobao.Adapters.MyRecyclerViewAdapter;
import com.example.my_taobao.Base.BaseFragment;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.Custom.MyRecyclerView;
import com.example.my_taobao.Fragments.HomePagerView;
import com.example.my_taobao.Fragments.ProductDetailsActivity;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class HomePagerFragment extends BaseFragment<HomePagerPresenter> implements HomePagerView {

    private final String TAG = "HomePagerFragment";

    private MyRecyclerView recyclerView;
    private ViewPager2 viewPager;
    private MyRecyclerViewAdapter recyclerViewAdapter;
    private CircleIndicator3 indicator;
    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.commodity_recyclerview);
        viewPager = view.findViewById(R.id.view_pager_recommend);
        indicator = view.findViewById(R.id.indicator);
        mPresenter.loadRecyclerView();
        mPresenter.loadFragments();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_items_fragment;
    }

    @Override
    public HomePagerPresenter getPresenterInstance() {
        return new HomePagerPresenter();
    }


    @Override
    public void setupRecyclerView(List<Commodity> commodities) {
        int columnCount = 2;
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewAdapter = new MyRecyclerViewAdapter(commodities);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
                Commodity commodity = commodities.get(position);
                intent.putIntegerArrayListExtra("images", (ArrayList<Integer>) commodity.getImages());
                intent.putExtra("text", commodity.getCommodityText());
                intent.putExtra("price", commodity.getCommodityPrice());
                intent.putExtra("priceDecrase", commodity.getCommodityDecrase());
                intent.putExtra("sell", commodity.getCommoditySell());
                startActivity(intent);
            }
        });
    }

    public void setupViewPager(List<Fragment> fragments) {
        Log.d(TAG, "setupViewPager: " + fragments.size());
        PicturesFragmentAdapter adapter = new PicturesFragmentAdapter(this, fragments);
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
    }
}
