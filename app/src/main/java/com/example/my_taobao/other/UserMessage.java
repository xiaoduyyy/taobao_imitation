package com.example.my_taobao.other;

public class UserMessage {

    private int userImage;
    private String userName;
    private String userMessage;
    private String userDate;

    public UserMessage(int userImage, String userName, String userMessage, String userDate) {
        this.userImage = userImage;
        this.userName = userName;
        this.userMessage = userMessage;
        this.userDate = userDate;
    }

    public UserMessage() {
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "userImage=" + userImage +
                ", userName='" + userName + '\'' +
                ", userMessage='" + userMessage + '\'' +
                ", userDate='" + userDate + '\'' +
                '}';
    }
}
