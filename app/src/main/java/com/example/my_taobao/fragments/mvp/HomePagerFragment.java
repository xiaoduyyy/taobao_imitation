package com.example.my_taobao.fragments.mvp;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.my_taobao.adapters.MyRecyclerViewAdapter;
import com.example.my_taobao.adapters.PicturesFragmentAdapter;
import com.example.my_taobao.base.BaseFragment;
import com.example.my_taobao.other.Commodity;
import com.example.my_taobao.custom.MyRecyclerView;
import com.example.my_taobao.fragments.HomePagerView;
import com.example.my_taobao.fragments.ProductDetailsActivity;
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
                intent.putExtra("longimage1", commodity.getLongImage1());
                intent.putExtra("longimage2", commodity.getLongImage2());
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
