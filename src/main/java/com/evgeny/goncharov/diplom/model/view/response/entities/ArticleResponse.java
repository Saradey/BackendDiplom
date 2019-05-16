package com.evgeny.goncharov.diplom.model.view.response.entities;

import com.evgeny.goncharov.diplom.model.model.Article;

import java.util.List;

public class ArticleResponse implements Response{

    private List<Article> list;

    public ArticleResponse(List<Article> list) {
        this.list = list;
    }

    public List<Article> getList() {
        return list;
    }

    public void setList(List<Article> list) {
        this.list = list;
    }

}
