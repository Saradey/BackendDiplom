package com.evgeny.goncharov.diplom.model.request;

public class RequestBase {

    protected String apiKey;

    public RequestBase(String apiKey) {
        this.apiKey = apiKey;
    }

    public RequestBase() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKe) {
        this.apiKey = apiKe;
    }
}
