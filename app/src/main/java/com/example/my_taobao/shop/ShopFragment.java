package com.example.my_taobao.shop;

import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.adapters.CartRecyclerViewAdapter;
import com.example.my_taobao.base.BaseFragment;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.fragments.ProductDetailsActivity;
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
    private ImageView cartEmpty;

    @Override
    public void onStart() {
        super.onStart();
        commoditiesIsEmptyOrNot();
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

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
                    int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();

                    // 遍历所有可见的 item，并更新其显示状态
                    for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(i);
                        if (viewHolder != null) {
                            LinearLayout incraseAndDecraseLayout = viewHolder.itemView.findViewById(R.id.incrase_and_decrase_layout);
                            Commodity commodity = commodities.get(i);
                            incraseAndDecraseLayout.setVisibility(View.GONE);
                        }
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
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
        cartEmpty = view.findViewById(R.id.empty_cart_image);
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
            public void onItemClick(int position, int viewId, CartRecyclerViewAdapter.MyViewHolder holder) {
                if (viewId == R.id.collect_cart) {
                    if (areAllItemsSelected(commodities)) {
                        sellectAll.setChecked(true);
                    } else {
                        sellectAll.setChecked(false);
                    }
                    updateTotalPrice();
                } else if (viewId == R.id.commodity_text_cart) {
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
        commoditiesIsEmptyOrNot();
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    private void commoditiesIsEmptyOrNot() {
        if (commodities == null || commodities.size() == 0) {
            cartEmpty.setVisibility(View.VISIBLE);
        } else {
            cartEmpty.setVisibility(View.INVISIBLE);
        }
    }

}
