package com.evgeny.goncharov.diplom.service.impl;

import com.evgeny.goncharov.diplom.model.model.Article;
import com.evgeny.goncharov.diplom.model.request.RequestCreateArticle;
import com.evgeny.goncharov.diplom.repository.ArticleRepository;
import com.evgeny.goncharov.diplom.service.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    private static final int SIZE_LIMIT = 10;


    @Override
    public void saveArticle(RequestCreateArticle article) {
        Article articleModel = new Article(article);
        //бизнес логика на проверку данных
        articleRepository.saveAndFlush(articleModel);
    }


    @Override
    public boolean deleteArticle(long idArticle) {
        if (articleRepository.existsById(idArticle)){
            articleRepository.deleteById(idArticle);
            return true;
        } else return false;
    }


    //при первой загрузки стены
    @Override
    public List<Article> getLastArticle() {
        Pageable pageable = PageRequest.of(0, SIZE_LIMIT, Sort.Direction.DESC, "id");
        return articleRepository.getLastArticle(pageable);
    }


    //при прокрутке
    @Override
    public List<Article> getArticleOffset(long idOffset) {
        Pageable pageable = PageRequest.of(0, SIZE_LIMIT, Sort.Direction.DESC, "id");
        return articleRepository.getOffsetArticle(idOffset, pageable);
    }


    //статьи пользователя
    @Override
    public List<Article> getArticleForUser(String login) {
        List<Article> articles = articleRepository.getArticleForUser(login);
        System.out.println("getArticleForUser " + login);
        return articles;
    }



}
