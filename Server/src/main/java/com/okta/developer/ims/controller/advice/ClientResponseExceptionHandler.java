package com.okta.developer.ims.controller.advice;

import com.okta.developer.ims.dto.ClientResponse;
import com.okta.developer.ims.dto.Message;
import com.okta.developer.ims.exception.BaseException;
import com.okta.developer.ims.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ClientResponseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final ClientResponse<Object> handleBaseException(BaseException ex) {
        Message userMessage = new Message(ex.getErrorCode(),ex.getMessage(),Constants.MessageType.ERROR);
        return new ClientResponse<>(userMessage);
    }
}
