package com.evgeny.goncharov.diplom.common.exeptions.handle;

import com.evgeny.goncharov.diplom.common.consts.ApiAnswer;
import com.evgeny.goncharov.diplom.common.exeptions.ApiKeyInvalidException;
import com.evgeny.goncharov.diplom.common.exeptions.UserWasException;
import com.evgeny.goncharov.diplom.model.view.AnyResponse;
import com.evgeny.goncharov.diplom.model.view.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandleExceptionsUsers {


    @ExceptionHandler(UserWasException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> nameWas() {
        return new ResponseEntity<BaseResponse>(new AnyResponse(ApiAnswer.NAME_WAS),
                new HttpHeaders(),
                HttpStatus.CONFLICT);
    }



    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> nameError(){
        return new ResponseEntity<BaseResponse>(new AnyResponse(ApiAnswer.ERROR_USERNAME),
                new HttpHeaders(),
                HttpStatus.CONFLICT);
    }



    @ExceptionHandler(ApiKeyInvalidException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> invalidApiKey(){
        return new ResponseEntity<BaseResponse>(new AnyResponse(ApiAnswer.ERROR_API_KEY),
                new HttpHeaders(),
                HttpStatus.CONFLICT);
    }


}
