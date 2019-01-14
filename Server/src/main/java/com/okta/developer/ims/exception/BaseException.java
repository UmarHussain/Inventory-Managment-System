package com.okta.developer.ims.exception;


import com.okta.developer.ims.dto.Message;
import lombok.Data;

import java.util.Arrays;

@Data
public class BaseException extends Exception {

    private static final long serialVersionUID = 1L;
    protected String errorCode;
    protected String[] parameters;
    protected Message userMessage;

    public BaseException() {
    }

    public BaseException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
        this.userMessage = new Message(errorCode, (String)null);
    }

    public BaseException(String errorCode, String[] parameters) {
        super(String.format("%s - %s", errorCode, Arrays.toString(parameters)));
        this.errorCode = errorCode;
        if (parameters != null) {
            this.parameters = (String[])Arrays.copyOf(parameters, parameters.length);
        }
        this.userMessage = new Message(errorCode, (String)null);
    }

    public BaseException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.userMessage = new Message(errorCode, (String)null);
    }

    public BaseException(String errorCode, String[] parameters, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        if (parameters != null) {
            this.parameters = (String[])Arrays.copyOf(parameters, parameters.length);
        }

        this.userMessage = new Message(errorCode, (String)null);
    }

    public BaseException(Message message) {
        super(message != null ? message.toString() : "");
        this.userMessage = message;
    }

    public BaseException(BaseException be) {
        super(be.getMessage());
        this.setUserMessage(be.getUserMessage());
        this.errorCode = be.getErrorCode();
        this.parameters = be.getParameters();
    }

    public BaseException(Throwable arg0) {
        super(arg0);
    }

    public BaseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public String[] getParameters() {
        String[] parametersClone = null;
        if (this.parameters != null) {
            parametersClone = (String[])Arrays.copyOf(this.parameters, this.parameters.length);
        }

        return parametersClone;
    }
}
