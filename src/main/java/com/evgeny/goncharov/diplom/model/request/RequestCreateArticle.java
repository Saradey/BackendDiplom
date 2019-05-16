package com.evgeny.goncharov.diplom.model.request;

public class RequestCreateArticle extends RequestBase{

    private String nameArticle;

    private String username;

    private String textArticle;

    public RequestCreateArticle() {
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTextArticle() {
        return textArticle;
    }

    public void setTextArticle(String textArticle) {
        this.textArticle = textArticle;
    }
}
