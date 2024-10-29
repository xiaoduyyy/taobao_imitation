package com.example.my_taobao.Fragments.mvp;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.my_taobao.Adapters.MyRecyclerViewAdapter;
import com.example.my_taobao.Base.BaseFragment;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.Custom.MyRecyclerView;
import com.example.my_taobao.Fragments.HomePagerView;
import com.example.my_taobao.R;

import java.util.List;

public class HomePagerFragment extends BaseFragment<HomePagerPresenter> implements HomePagerView {

    private MyRecyclerView recyclerView;
    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.commodity_recyclerview);
        mPresenter.loadRecyclerView();
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

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyRecyclerViewAdapter(commodities));
    }
}
