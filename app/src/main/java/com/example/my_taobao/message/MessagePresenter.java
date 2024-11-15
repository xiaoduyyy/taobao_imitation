package com.example.my_taobao.message;

import com.example.my_taobao.base.BasePresenter;
import com.example.my_taobao.other.ServerCard;
import com.example.my_taobao.other.UserMessage;

import java.util.List;

public class MessagePresenter extends BasePresenter<MessageModel, MessageFragment> {

    private final String TAG = "MessagePresenter";


    public void loadCards() {
        List<ServerCard> lists = mModel.getLists();
        if (getmView() != null) {
            getmView().setTopRecyclerView(lists);
        }
    }

    public void loadUsers() {
        List<UserMessage> messages = mModel.getMessages();
        if (getmView() != null) {
            getmView().setMessage(messages);
        }
    }

    @Override
    public MessageModel getModelInstance() {
        return new MessageModel(this);
    }

    public void loadUsersBefore() {
        List<UserMessage> messages = mModel.getBeforeMessages();
        if (getmView() != null) {
            getmView().setBeforeMessage(messages);
        }
    }
}
