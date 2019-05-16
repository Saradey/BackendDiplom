package com.evgeny.goncharov.diplom.service.interfaces;

import com.evgeny.goncharov.diplom.model.model.Article;
import com.evgeny.goncharov.diplom.model.request.RequestCreateArticle;

import java.util.List;

public interface ArticleService {

    void saveArticle(RequestCreateArticle article);

    boolean deleteArticle(long idArticle);

    List<Article> getLastArticle();

    List<Article> getArticleOffset(long idOffset);

    List<Article> getArticleForUser(String login);

}