package com.okta.developer.ims.utils;

import com.okta.developer.ims.dto.ClientResponse;
import com.okta.developer.ims.dto.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.okta.developer.ims.utils.Constants.UserMessage.*;
import static com.okta.developer.ims.utils.Constants.MessageType.*;

/***
 * A factory to create ClientResponse
 *
 * */
public final class ClientResponseFactory {

    private static final Logger LOGGER = LogManager.getLogger(ClientResponseFactory.class);

    ClientResponseFactory(){}

    public static <T> ClientResponse<T> getClientResponse(String actionType, T t){
        ClientResponse<T> response = null;
        Message userMessage;
        switch(actionType){
            case DATA_CREATED:
                userMessage = new Message(DATA_CREATED,DATA_CREATED,SUCCESS);
                response = new ClientResponse<>(userMessage, t);
                break;
            case DATA_UPDATED:
                userMessage = new Message(DATA_UPDATED,DATA_UPDATED,SUCCESS);
                response = new ClientResponse<>(userMessage, t);
                break;
            case DATA_RETRIEVED:
                userMessage = new Message(DATA_RETRIEVED,DATA_RETRIEVED,INFO);
                response = new ClientResponse<>(userMessage, t);
                break;
            case DATA_DELETED:
                userMessage = new Message(DATA_DELETED,DATA_DELETED,SUCCESS);
                response = new ClientResponse<>(userMessage, t);
                break;
            default:
                LOGGER.info("Action Type does not match with {}",actionType);
        }
        return response;
    }
}
