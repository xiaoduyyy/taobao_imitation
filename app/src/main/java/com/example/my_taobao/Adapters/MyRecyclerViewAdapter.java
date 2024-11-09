package com.example.my_taobao.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Commodity> commodities;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public MyRecyclerViewAdapter(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commodity_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Commodity commodity = commodities.get(position);
        holder.imageView.setImageResource(commodity.getCommodityImage());
        holder.textView.setText(commodity.getCommodityText());
        holder.priceDecrase.setText(commodity.getCommodityDecrase());
        holder.price.setText(commodity.getCommodityPrice());
        holder.sellNumber.setText(commodity.getCommoditySell());

        final int currentPosition = position;
        // 设置 itemView 的点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(currentPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodities == null ? 0 : commodities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private TextView price;
        private TextView priceDecrase;
        private TextView sellNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.commodity_image);
            textView = itemView.findViewById(R.id.commodity_text);
            price = itemView.findViewById(R.id.commodity_price);
            priceDecrase = itemView.findViewById(R.id.commodity_text_from);
            sellNumber = itemView.findViewById(R.id.commodity_sellnumber);
        }
    }
}
