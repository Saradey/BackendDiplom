package com.evgeny.goncharov.diplom.model.view.response;

import com.evgeny.goncharov.diplom.model.view.response.entities.Response;

public class ResponseStructure {

    private Response response;

    public ResponseStructure(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
