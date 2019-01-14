package com.okta.developer.ims.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A generic Client Response to be send for each REST service response
 * it used Message to prompt correct message to user
 *
 * @see java.io.Serializable
 * @see com.okta.developer.ims.dto.Message
 * @author mwasif
 *
 * */
@Data
public class ClientResponse<T> implements Serializable {
    private Message message;
    private T data;

    public ClientResponse() {
    }

    public ClientResponse(Message message, T data) {
        this.message = message;
        this.data = data;
    }

    public ClientResponse(Message message) {
        this.message = message;
    }

}