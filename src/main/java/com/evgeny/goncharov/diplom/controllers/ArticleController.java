package com.evgeny.goncharov.diplom.controllers;

import com.evgeny.goncharov.diplom.common.consts.ApiAnswer;
import com.evgeny.goncharov.diplom.common.exeptions.DeleteArticleException;
import com.evgeny.goncharov.diplom.model.model.Article;
import com.evgeny.goncharov.diplom.model.request.RequestCreateArticle;
import com.evgeny.goncharov.diplom.model.request.RequestDeleteArticle;
import com.evgeny.goncharov.diplom.model.view.code.AnyResponse;
import com.evgeny.goncharov.diplom.model.view.code.BaseResponse;
import com.evgeny.goncharov.diplom.model.view.response.ResponseStructure;
import com.evgeny.goncharov.diplom.model.view.response.entities.ArticleResponse;
import com.evgeny.goncharov.diplom.service.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.evgeny.goncharov.diplom.common.consts.ApiMethod;

import java.util.List;

@RestController
public class ArticleController {


    @Autowired
    ArticleService articleService;


    //{"nameArticle":"Тестовая статья", "apiKe":"2f1b2391fe4f1db4e185c100cc370a90", "username":"ISarad", "textArticle":"Призван по мобилизации в августе 1941 года. Прошел всю войну в составе 8 отдельного гвардейского батальона связи. С 13 декабря 1942 года воевал  на Сталинградском, Южном Донском и 4-м Украинском фронтах. С июля 1944 года  - 1-м, 2-м  Прибалтийском  и Ленинградским фронтах. В мае 1942 года был вручен знак Гвардия.  Имеет благодарности Верховного Главнокомандующего за освобождение Севастополя (приказ № 66, от 10.05.1944), Шауляя (приказ № 133, от 27.07.1944), Митавы (приказ № 137, от 31.07.1944). В его красноармейской книжке есть и запись о Благодарности командующего Ленинградским фронтом от 3 июля 1945 года. Демобилизован на основании приказа Верховного Совета СССР от 25 августа 1945 года."}
    @PostMapping(ApiMethod.CREATE_ARTICLE)
    public ResponseEntity<BaseResponse> createArticlePost(@RequestBody RequestCreateArticle article) {
        articleService.saveArticle(article);
        return new ResponseEntity<BaseResponse>(new AnyResponse(ApiAnswer.CRE_ART), new HttpHeaders(), HttpStatus.OK);
    }


    //{"idArticle":"1", "apiKe":"2f1b2391fe4f1db4e185c100cc370a90"}
    @PostMapping(ApiMethod.DELETE_ARTICLE)
    public ResponseEntity<BaseResponse> deleteArticlePost(@RequestBody RequestDeleteArticle article) throws DeleteArticleException {
        articleService.deleteArticle(article.getIdArticle());
        return new ResponseEntity<BaseResponse>(new AnyResponse(ApiAnswer.CRE_DEL), new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping(ApiMethod.GET_LAST_ARTICLE)
    public ResponseEntity<ResponseStructure> lastArticleGet(@RequestParam String apiKey) {
        List<Article> lastArticle = articleService.getLastArticle();
        ArticleResponse response = new ArticleResponse(lastArticle);
        return new ResponseEntity<ResponseStructure>(
                new ResponseStructure(
                        response), new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping(ApiMethod.GET_ARTICLE_OFFSET)
    public ResponseEntity<ResponseStructure> articleOffsetGet(@RequestParam String apiKey, @RequestParam String idOffset) {
        List<Article> dataOffset = articleService.getArticleOffset(Long.valueOf(idOffset));
        ArticleResponse articleResponse = new ArticleResponse(dataOffset);
        return new ResponseEntity<ResponseStructure>(
                new ResponseStructure(
                        articleResponse), new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping(ApiMethod.GET_ARTICLE_FOR_USER)
    public ResponseEntity<ResponseStructure> articleUserGet(@RequestParam String apiKey, @RequestParam String username) {
        List<Article> dataUser = articleService.getArticleForUser(username);
        ArticleResponse articleResponse = new ArticleResponse(dataUser);
        return new ResponseEntity<ResponseStructure>(
                new ResponseStructure(
                        articleResponse), new HttpHeaders(), HttpStatus.OK);
    }


}
