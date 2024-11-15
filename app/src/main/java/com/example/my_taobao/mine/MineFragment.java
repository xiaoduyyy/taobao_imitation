package com.example.my_taobao.mine;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.my_taobao.adapters.MyRecyclerViewAdapter;
import com.example.my_taobao.base.BaseFragment;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.fragments.ProductDetailsActivity;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends BaseFragment<MinePresenter> {

    private final String TAG = "MineFragment";

    private RecyclerView recyclerView;
    MyRecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.user_bottom_recyclerview);

        mPresenter.loadRecyclerView();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }

    @Override
    public MinePresenter getPresenterInstance() {
        return new MinePresenter();
    }

    public void setupRecyclerView(List<Commodity> commodities) {
        int columnCount = 2;
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(columnCount, StaggeredGridLayoutManager.VERTICAL);

        Log.d(TAG, "setupRecyclerView: " + commodities.size());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new MyRecyclerViewAdapter(commodities);
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
}
