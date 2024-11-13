package com.example.my_taobao.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.R;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.MyViewHolder> {

    private List<Commodity> commodities;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public CartRecyclerViewAdapter(List<Commodity> commodities) {
        this.commodities = commodities;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CartRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_recyclerview_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CartRecyclerViewAdapter.MyViewHolder holder, int position) {
        Commodity commodity = commodities.get(position);
        holder.image.setImageResource(commodity.getCommodityImage());
        holder.text.setText(commodity.getCommodityText());
        holder.price.setText(commodity.getCommodityPrice());
        holder.quantity.setText(String.valueOf(commodity.getQuantity()));
        holder.quantity.setText(String.valueOf(commodity.getQuantity()));
        final int currentPosition = position;

        holder.checkBox.setChecked(commodity.isSelected());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commodity.setSelected(holder.checkBox.isChecked());
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(currentPosition);
                }
                notifyItemChanged(currentPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodities == null ? 0 :commodities.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private ImageView image;
        private TextView text;
        private TextView price;
        private TextView quantity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.collect_cart);
            image = itemView.findViewById(R.id.commodity_image_cart);
            text = itemView.findViewById(R.id.commodity_text_cart);
            price = itemView.findViewById(R.id.price_cart);
            quantity = itemView.findViewById(R.id.commodity_number_cart);
        }
    }
}
