package com.evgeny.goncharov.diplom.model.request;

public class RequestBase {

    protected String apiKe;

    public RequestBase(String apiKe) {
        this.apiKe = apiKe;
    }

    public RequestBase() {
    }

    public String getApiKey() {
        return apiKe;
    }

    public void setApiKe(String apiKe) {
        this.apiKe = apiKe;
    }
}
