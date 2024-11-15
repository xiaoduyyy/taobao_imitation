package com.example.my_taobao.message;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_taobao.adapters.MessageRecentRecycelerViewAdapter;
import com.example.my_taobao.adapters.MessageTopRecyclerViewAdapter;
import com.example.my_taobao.base.BaseFragment;
import com.example.my_taobao.Class.ServerCard;
import com.example.my_taobao.Class.UserMessage;
import com.example.my_taobao.R;

import java.util.List;

public class MessageFragment extends BaseFragment<MessagePresenter> {

    private RecyclerView topRecyclerView;
    private RecyclerView messageRecentRecyclerView;
    private RecyclerView messageBeforeRecyclerView;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View view) {

        topRecyclerView = view.findViewById(R.id.message_top_recyclerview);
        messageRecentRecyclerView = view.findViewById(R.id.massage_recyclerview_recent);
        messageBeforeRecyclerView = view.findViewById(R.id.massage_recyclerview_before);
        mPresenter.loadCards();
        mPresenter.loadUsers();
        mPresenter.loadUsersBefore();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.message_fragment;
    }

    @Override
    public MessagePresenter getPresenterInstance() {
        return new MessagePresenter();
    }


    public void setTopRecyclerView(List<ServerCard> lists) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        topRecyclerView.setAdapter(new MessageTopRecyclerViewAdapter(lists));
        topRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void setMessage(List<UserMessage> messages) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        messageRecentRecyclerView.setAdapter(new MessageRecentRecycelerViewAdapter(messages));
        messageRecentRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void setBeforeMessage(List<UserMessage> messages) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        messageBeforeRecyclerView.setAdapter(new MessageRecentRecycelerViewAdapter(messages));
        messageBeforeRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
