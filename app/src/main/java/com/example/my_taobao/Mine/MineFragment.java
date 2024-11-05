package com.example.my_taobao.Mine;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.my_taobao.Adapters.MyRecyclerViewAdapter;
import com.example.my_taobao.Base.BaseFragment;
import com.example.my_taobao.Base.BasePresenter;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.Custom.MyRecyclerView;
import com.example.my_taobao.R;

import java.util.List;

public class MineFragment extends BaseFragment<MinePresenter> {

    private final String TAG = "MineFragment";

    private RecyclerView recyclerView;


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
        recyclerView.setAdapter(new MyRecyclerViewAdapter(commodities));

    }
}
