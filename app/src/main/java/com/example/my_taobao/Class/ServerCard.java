package com.example.my_taobao.Class;

public class ServerCard {

    private String text;
    private int imageResourse;
    private int imageColor;

    public int getImageColor() {
        return imageColor;
    }

    public void setImageColor(int imageColor) {
        this.imageColor = imageColor;
    }

    public ServerCard(String text, int imageResourse, int imageColor) {
        this.text = text;
        this.imageResourse = imageResourse;
        this.imageColor = imageColor;
    }

    public ServerCard() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    @Override
    public String toString() {
        return "ServerCard{" +
                "text='" + text + '\'' +
                ", imageResourse=" + imageResourse +
                ", imageColor=" + imageColor +
                '}';
    }
}
