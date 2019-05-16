package com.evgeny.goncharov.diplom.model.view;

public class AnyResponse implements BaseResponse{

    private String code;

    public AnyResponse(String code) {
        this.code = code;
    }

    public AnyResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
