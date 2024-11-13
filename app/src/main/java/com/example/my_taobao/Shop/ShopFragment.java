package com.example.my_taobao.Shop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.Adapters.CartRecyclerViewAdapter;
import com.example.my_taobao.Base.BaseFragment;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends BaseFragment<ShopPresenter> {

    private RecyclerView recyclerView;
    private CheckBox sellectAll;
    private TextView total;
    private ImageView buy;
    private List<Commodity> commodities;
    private IntentFilter filter;


    @Override
    public void onStart() {
        super.onStart();
        mPresenter.loadItems();
    }


    @Override
    protected void initListener() {
        sellectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = sellectAll.isChecked();
                updateAllItemsSelection(isChecked);
                updateTotalPrice();
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (commodities == null || commodities.size() == 0) {
                    Toast.makeText(mActivity, "您购物车里还没添加宝贝哦~", Toast.LENGTH_SHORT).show();
                } else if (!isItemSelected()){
                    Toast.makeText(mActivity, "您还没选择宝贝哦~", Toast.LENGTH_SHORT).show();
                } else {
                    showPurchaseDialog();
                }
            }
        });
    }

    private void showPurchaseDialog() {

        new android.app.AlertDialog.Builder(getContext())
                .setTitle("确认购买")  // 设置标题
                .setMessage("你确认要购买选中的商品吗？")  // 设置提示消息
                .setPositiveButton("确认", (dialog, which) -> {
                    List<Commodity> toRemove = new ArrayList<>();
                    for (Commodity commodity : commodities) {
                        if (commodity.isSelected()) {
                            toRemove.add(commodity);  // 将选中的商品加入待删除列表
                        }
                    }
                    mPresenter.removeSelectedCommodities(toRemove);
                    total.setText("0");
                    sellectAll.setChecked(false);
                    Toast.makeText(getContext(), "购买成功", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("取消", (dialog, which) -> {
                    Toast.makeText(getContext(), "购买已取消", Toast.LENGTH_SHORT).show();
                })
                .create()
                .show();
    }

    private void updateAllItemsSelection(boolean isSelected) {
        for (Commodity commodity : commodities) {
            commodity.setSelected(isSelected);
        }
        // 通知适配器更新界面
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.cart_recyclerview);
        sellectAll = view.findViewById(R.id.select_all);
        total = view.findViewById(R.id.total_price);
        buy = view.findViewById(R.id.settlement_button);
        mPresenter.loadItems();

        filter = new IntentFilter();
        filter.addAction("com.example.my_taobao.UPDATE_CART");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shop_fragment;
    }

    @Override
    public ShopPresenter getPresenterInstance() {
        return new ShopPresenter();
    }

    public void setupRecyclerView(List<Commodity> commodities) {
        this.commodities = commodities;
        CartRecyclerViewAdapter adapter = new CartRecyclerViewAdapter(commodities);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new CartRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (areAllItemsSelected(commodities)) {
                    sellectAll.setChecked(true);
                } else {
                    sellectAll.setChecked(false);
                }
                updateTotalPrice();
            }
        });
    }

    private boolean areAllItemsSelected(List<Commodity> commodities) {
        for (Commodity commodity : commodities) {
            if (!commodity.isSelected()) {
                return false;
            }
        }
        return true;
    }

    private boolean isItemSelected() {
        for (Commodity commodity : commodities) {
            if (commodity.isSelected()) {
                return true;
            }
        }
        return false;
    }

    private void updateTotalPrice() {
        Double add = 0.0;
        for (Commodity commodity : commodities) {
            if (commodity.isSelected()) {
                add += Double.parseDouble(commodity.getCommodityPrice()) * commodity.getQuantity();
            }
        }
        String format = String.format("%.2f", add);
        total.setText(format);
    }

    public void updateViewAfterDeletion() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
