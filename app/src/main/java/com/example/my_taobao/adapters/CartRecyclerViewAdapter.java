package com.example.my_taobao.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.other.Commodity;
import com.example.my_taobao.R;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.MyViewHolder> {

    private List<Commodity> commodities;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position, int viewId, MyViewHolder holder);
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
        final int currentPosition = position;
        holder.quamtityCommodity.setText(String.valueOf(commodity.getQuantity()));

        holder.checkBox.setChecked(commodity.isSelected());
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.collect_cart) {
                    commodity.setSelected(holder.checkBox.isChecked());
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(currentPosition, v.getId(), holder);
                    }
                    notifyItemChanged(currentPosition);
                } else if (v.getId() == R.id.sellected_quantity) {
                    holder.incraseAndDecraseLayout.setVisibility(View.VISIBLE);
                } else if (v.getId() == R.id.cart_incrase) {
                    onItemClickListener.onItemClick(currentPosition, v.getId(), holder);
                    commodity.setQuantity(commodity.getQuantity() + 1);
                    holder.quantity.setText(String.valueOf(commodity.getQuantity()));
                    onItemClickListener.onItemClick(currentPosition, v.getId(), holder);
                    holder.quamtityCommodity.setText(String.valueOf(commodity.getQuantity()));
                    notifyItemChanged(currentPosition);
                } else if (v.getId() == R.id.cart_decrase) {
                    onItemClickListener.onItemClick(currentPosition, v.getId(), holder);
                    if (commodity.getQuantity() > 1) {
                        commodity.setQuantity(commodity.getQuantity() - 1);
                        holder.quantity.setText(String.valueOf(commodity.getQuantity()));
                        holder.quamtityCommodity.setText(String.valueOf(commodity.getQuantity()));
                        notifyItemChanged(currentPosition);
                    } else {
                        Toast.makeText(v.getContext(), "该宝贝不能减少了哦~", Toast.LENGTH_SHORT).show();
                    }
                } else if (v.getId() == R.id.commodity_text_cart) {
                    onItemClickListener.onItemClick(currentPosition, R.id.commodity_text_cart, holder);
                }
            }
        };
        holder.checkBox.setOnClickListener(clickListener);
        holder.layout.setOnClickListener(clickListener);
        holder.incrase.setOnClickListener(clickListener);
        holder.decrase.setOnClickListener(clickListener);
        holder.text.setOnClickListener(clickListener);
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
        private TextView quantity, quamtityCommodity;
        private LinearLayout layout, incraseAndDecraseLayout;
        private Button incrase, decrase;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.collect_cart);
            image = itemView.findViewById(R.id.commodity_image_cart);
            text = itemView.findViewById(R.id.commodity_text_cart);
            price = itemView.findViewById(R.id.price_cart);
            quantity = itemView.findViewById(R.id.commodity_number_cart);
            layout = itemView.findViewById(R.id.sellected_quantity);
            incrase = itemView.findViewById(R.id.cart_incrase);
            decrase = itemView.findViewById(R.id.cart_decrase);
            incraseAndDecraseLayout = itemView.findViewById(R.id.incrase_and_decrase_layout);
            quamtityCommodity = itemView.findViewById(R.id.quantity_commodity);
        }
    }
}
