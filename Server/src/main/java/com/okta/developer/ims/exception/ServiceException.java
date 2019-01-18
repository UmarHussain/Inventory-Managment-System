package com.okta.developer.ims.exception;

public class ServiceException extends BaseException {
    public ServiceException() {
    }

    public ServiceException(String arg0) {
        super(arg0);
    }

    public ServiceException(String key, String[] parameters) {
        super(key, parameters);
    }

    public ServiceException(BaseException arg0) {
        super(arg0);
    }

    public ServiceException(Throwable arg0) {
        super(arg0);
    }

    public ServiceException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
}
