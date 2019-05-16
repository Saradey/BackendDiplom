package com.evgeny.goncharov.diplom.model.model;

import com.evgeny.goncharov.diplom.model.request.RequestCreateArticle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    //5000 примерно 2 страницы
    @Column(name = "text", length = 5000, nullable = false)
    private String text;

    @Column(name = "name_article", length = 50, nullable = false)
    private String nameArticle;

    //    foreign_key User
    @Column(name = "id_user_foreign_key", length = 50, nullable = false)
    private String id_user;


    public Article(RequestCreateArticle article) {
        text = article.getTextArticle();
        nameArticle = article.getNameArticle();
        id_user = article.getUsername();
    }

    public Article() {
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
