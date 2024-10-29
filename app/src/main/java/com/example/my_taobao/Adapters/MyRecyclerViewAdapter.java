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


    public MyRecyclerViewAdapter(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commodity_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        Commodity commodity = commodities.get(position);
        holder.imageView.setImageResource(commodity.getCommodityImage());
        holder.textView.setText(commodity.getCommodityText());
    }

    @Override
    public int getItemCount() {
        return commodities == null ? 0 : commodities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.commodity_image);
            textView = itemView.findViewById(R.id.commodity_text);
        }
    }
}
