package com.example.my_taobao.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.Class.UserMessage;
import com.example.my_taobao.R;

import java.util.List;

public class MessageRecentRecycelerViewAdapter extends RecyclerView.Adapter<MessageRecentRecycelerViewAdapter.MyHolder> {

    private List<UserMessage> messages;

    public MessageRecentRecycelerViewAdapter(List<UserMessage> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_recent_recyclerview_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        UserMessage userMessage = messages.get(position);
        holder.userImage.setImageResource(userMessage.getUserImage());
        holder.userName.setText(userMessage.getUserName());
        holder.userMessage.setText(userMessage.getUserMessage());
        holder.date.setText(userMessage.getUserDate());
    }

    @Override
    public int getItemCount() {
        return messages == null ? 0 : messages.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView userImage;
        private TextView userName;
        private TextView userMessage;
        private TextView date;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_avatar);
            userName = itemView.findViewById(R.id.user_name);
            userMessage = itemView.findViewById(R.id.user_message);
            date = itemView.findViewById(R.id.user_date);
        }
    }
}
