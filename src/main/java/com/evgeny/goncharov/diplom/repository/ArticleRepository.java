package com.evgeny.goncharov.diplom.repository;

import com.evgeny.goncharov.diplom.model.model.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    //при первой загрузки стены
    @Query(value = "select * from article", nativeQuery = true)
    List<Article> getLastArticle(Pageable pageable);

    //при прокрутки стены
    @Query(value = "select * from article where id < :offset", nativeQuery = true)
    List<Article> getOffsetArticle(@Param("offset") long offset, Pageable pageable);

    @Query(value = "select * from article where id_user_foreign_key = :id_user", nativeQuery = true)
    List<Article> getArticleForUser(@Param("id_user") String idUser);


}
