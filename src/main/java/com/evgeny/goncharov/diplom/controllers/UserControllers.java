package com.evgeny.goncharov.diplom.controllers;

import com.evgeny.goncharov.diplom.common.consts.ApiAnswer;
import com.evgeny.goncharov.diplom.common.consts.ApiMethod;
import com.evgeny.goncharov.diplom.common.exeptions.UserWasException;
import com.evgeny.goncharov.diplom.model.request.RequestBase;
import com.evgeny.goncharov.diplom.model.request.RequestRegUser;
import com.evgeny.goncharov.diplom.model.view.code.AnyResponse;
import com.evgeny.goncharov.diplom.model.view.code.BaseResponse;
import com.evgeny.goncharov.diplom.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserControllers {

    @Autowired
    UserService userService;

    //{"name" : "LordSarad", "password":"132",  "email":"1234@1234.ru", "apiKe":"2f1b2391fe4f1db4e185c100cc370a90"}
    @PostMapping(ApiMethod.REGISTRATION_USER)
    public ResponseEntity<BaseResponse> registrationUserPost(@RequestBody RequestRegUser user) throws UserWasException {
        userService.regUser(user);
        return new ResponseEntity<BaseResponse>(new AnyResponse(ApiAnswer.REG_OK), new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping(ApiMethod.AUTHENTICATION)
    public ResponseEntity<BaseResponse> authorizationUserPost(@RequestBody RequestBase requestBase){
        return new ResponseEntity<BaseResponse>(new AnyResponse(ApiAnswer.AUT_OK), new HttpHeaders(), HttpStatus.OK);
    }


}
