package com.evgeny.goncharov.diplom.model.request;

public class RequestDeleteArticle extends RequestBase{

    private long idArticle;

    public RequestDeleteArticle(){}

    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
        this.idArticle = idArticle;
    }
}
