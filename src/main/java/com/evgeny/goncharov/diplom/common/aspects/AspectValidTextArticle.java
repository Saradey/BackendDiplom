package com.evgeny.goncharov.diplom.common.aspects;

import com.evgeny.goncharov.diplom.common.exeptions.BadWordsException;
import com.evgeny.goncharov.diplom.model.request.RequestCreateArticle;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Aspect
@PropertySource("classpath:badWords.txt")
public class AspectValidTextArticle {

    @Value("${words}")
    String badWords;

    private String regex = "";


    @Pointcut("execution(* *.createArticlePost(..)) && args(createArticle)")
    public void validateTextPointCut(RequestCreateArticle createArticle){ }


    @Before(value = "validateTextPointCut(createArticle)", argNames = "createArticle")
    public void validateText(RequestCreateArticle createArticle) throws BadWordsException {
        String textArticle = createArticle.getTextArticle();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textArticle);
        while (matcher.find()) {
            throw new BadWordsException();
        }
    }



    @PostConstruct
    public void initRegex(){
        badWords = badWords.replaceAll(" ", "");
        List<String> words = Arrays.asList(badWords.split(","));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            stringBuilder.append("\\b(?:(?iu)");
            stringBuilder.append(words.get(i));
            stringBuilder.append(")\\b");
            if (words.size() - 1 != i) {
                stringBuilder.append("|");
            }
        }
        regex = stringBuilder.toString();
    }



}
