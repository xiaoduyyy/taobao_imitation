package com.example.my_taobao.Message;

import com.example.my_taobao.Base.BaseModel;
import com.example.my_taobao.Class.ServerCard;
import com.example.my_taobao.Class.UserMessage;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.List;

public class MessageModel extends BaseModel<MessagePresenter> {
    public MessageModel(MessagePresenter presenter) {
        super(presenter);
    }

    public List<ServerCard> getLists() {
        List<ServerCard> newLists = new ArrayList<>();
        newLists.add(new ServerCard("物流", R.drawable.logistic_icon, R.color.logistic_icon));
        newLists.add(new ServerCard("售后", R.drawable.after_sale_icon, R.color.after_sale_icon));
        newLists.add(new ServerCard("提醒", R.drawable.remind_icon, R.color.remind_icon));
        newLists.add(new ServerCard("互动", R.drawable.puzzle_icon, R.color.puzzle_icon));
        newLists.add(new ServerCard("赞评", R.drawable.credit_icon, R.color.credit_icon));
        newLists.add(new ServerCard("其他", R.drawable.message_for_icon, R.color.message_for_icon));
        return newLists;
    }

    public List<UserMessage> getMessages() {
        List<UserMessage> messages = new ArrayList<>();
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我是刘振羊", "星期一"));
        return messages;
    }

    public List<UserMessage> getBeforeMessages() {
        List<UserMessage> messages = new ArrayList<>();
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我bu是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我bu是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我bu是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我bu是刘振羊", "星期一"));
        messages.add(new UserMessage(R.drawable.avatar_xyy, "喜羊羊", "你好我bu是刘振羊", "星期一"));
        return messages;
    }
}
