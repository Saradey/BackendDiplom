package com.evgeny.goncharov.diplom.common.aspects;

import com.evgeny.goncharov.diplom.common.consts.ApiConsts;
import com.evgeny.goncharov.diplom.common.exeptions.ApiKeyInvalidException;
import com.evgeny.goncharov.diplom.model.request.RequestBase;
import com.evgeny.goncharov.diplom.model.request.RequestRegUser;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;




@Component
@Aspect
public class AspectValidApiKey {

    @Pointcut("execution(* com.evgeny.goncharov.diplom.controllers.*.*(..)) && args(requestBase)")
    public void pointcutValidApiKeyAllMethod(RequestBase requestBase){ }


    @Before(value = "pointcutValidApiKeyAllMethod(requestBase)", argNames = "requestBase")
    public void validateApbKey(RequestBase requestBase) throws ApiKeyInvalidException {
        if(!requestBase.getApiKey().equals(ApiConsts.API_KEY))
            throw new ApiKeyInvalidException();
    }

}