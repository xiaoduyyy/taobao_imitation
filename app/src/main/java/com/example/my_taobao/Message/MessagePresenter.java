package com.example.my_taobao.Message;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.example.my_taobao.Base.BasePresenter;
import com.example.my_taobao.Class.ServerCard;
import com.example.my_taobao.Class.UserMessage;

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
