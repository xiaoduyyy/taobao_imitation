package com.example.my_taobao.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.other.ServerCard;
import com.example.my_taobao.R;

import java.util.List;

public class MessageTopRecyclerViewAdapter extends RecyclerView.Adapter<MessageTopRecyclerViewAdapter.ViewHolder> {

    private List<ServerCard> serverCardList;

    public MessageTopRecyclerViewAdapter(List<ServerCard> sreverCardList) {
        this.serverCardList = sreverCardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_top_recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageTopRecyclerViewAdapter.ViewHolder holder, int position) {
        ServerCard serverCard = serverCardList.get(position);
        holder.text.setText(serverCard.getText());
        holder.text.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), serverCard.getImageColor()));
        holder.image.setImageResource(serverCard.getImageResourse());
    }

    @Override
    public int getItemCount() {
        return serverCardList == null ? 0 : serverCardList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.recyclreview_item_name);
            image = itemView.findViewById(R.id.recyclreview_image);
        }
    }
}
