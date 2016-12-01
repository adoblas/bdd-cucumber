package com.adoblas.cuke.stepDefintions.util;

import com.ning.http.client.Response;
import com.sun.jersey.api.client.ClientResponse;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.util.List;

@ContextConfiguration("classpath:cucumber.xml")
public class RestClientContext {
    private ClientResponse clientResponse;
    private int responseStatus;
    private String responseJson;

    private boolean isReaded = false;

    public ClientResponse getResponse() {
        return clientResponse;
    }

    public void setResponse(ClientResponse response) {
        this.clientResponse = response;
    }

    public String getResponseJson() {
        if (!isReaded) {
            responseJson = clientResponse.getEntity(String.class);
            isReaded = true;
        }
        return responseJson;
    }

    public void setResponseStatus(int status){
        this.responseStatus = status;
    }

    public int getResponseStatus(){
        responseStatus = clientResponse.getStatus();
        return responseStatus;
    }

}
