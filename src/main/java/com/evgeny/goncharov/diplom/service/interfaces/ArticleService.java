package com.evgeny.goncharov.diplom.service.interfaces;

import com.evgeny.goncharov.diplom.common.exeptions.DeleteArticleException;
import com.evgeny.goncharov.diplom.model.model.Article;
import com.evgeny.goncharov.diplom.model.request.RequestCreateArticle;

import java.util.List;

public interface ArticleService {

    void saveArticle(RequestCreateArticle article);

    void deleteArticle(long idArticle) throws DeleteArticleException;

    List<Article> getLastArticle();

    List<Article> getArticleOffset(long idOffset);

    List<Article> getArticleForUser(String login);

}