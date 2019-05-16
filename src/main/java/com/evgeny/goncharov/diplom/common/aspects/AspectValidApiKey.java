package com.evgeny.goncharov.diplom.common.aspects;

import com.evgeny.goncharov.diplom.common.consts.ApiConsts;
import com.evgeny.goncharov.diplom.common.exeptions.ApiKeyInvalidException;
import com.evgeny.goncharov.diplom.model.request.RequestBase;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AspectValidApiKey {

    @Pointcut("execution(* com.evgeny.goncharov.diplom.controllers.*.*Post(..)) && args(requestBase)")
    public void pointcutValidApiKeyAllPostMethod(RequestBase requestBase) {
    }

    @Pointcut("execution(* com.evgeny.goncharov.diplom.controllers.*.*Get(String,..)) && args(apiKey)")
    public void pointcutValidApiKeyAllGetMethod(String apiKey) {
    }

    @Pointcut("execution(* com.evgeny.goncharov.diplom.controllers.*.*Get(String,String)) && args(apiKey,username)")
    public void pointcutValidApiKeyAllGetMethodTwoParam(String apiKey, String username) {
    }


    @Before(value = "pointcutValidApiKeyAllPostMethod(requestBase)", argNames = "requestBase")
    public void validateApiKeyPost(RequestBase requestBase) throws ApiKeyInvalidException {
        if (!requestBase.getApiKey().equals(ApiConsts.API_KEY) || requestBase.getApiKey() == null)
            throw new ApiKeyInvalidException();
    }


    @Before(value = "pointcutValidApiKeyAllGetMethod(apiKey)", argNames = "apiKey")
    public void validateApiKeyGet(String apiKey) throws ApiKeyInvalidException {
        if (!apiKey.equals(ApiConsts.API_KEY) || apiKey == null)
            throw new ApiKeyInvalidException();
    }


    @Before(value = "pointcutValidApiKeyAllGetMethodTwoParam(apiKey,username)", argNames = "apiKey,username")
    public void validateApiKeyGetTwoParam(String apiKey, String username) throws ApiKeyInvalidException {
        if (!apiKey.equals(ApiConsts.API_KEY) || apiKey == null)
            throw new ApiKeyInvalidException();
    }


}