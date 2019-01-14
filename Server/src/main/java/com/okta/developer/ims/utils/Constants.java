package com.okta.developer.ims.utils;

public class Constants {
	public static final Integer ENABLED = 1;
    public static final Integer DISABLED = 0;

    public static class ErrorMessage {
        public static final String MANDATORY_DATA = "MANDATORY_DATA";
    }

    public static class ModelFields {
        public static final String INVENTORY_NAME = "INVENTORY_NAME";
        public static final String INVENTORY_QUANTITY = "INVENTORY_QUANTITY";
        public static final String INVENTORY_TYPE = "INVENTORY_TYPE";
    }

    public static class MessageType {
        public static final String ERROR = "ERROR";
        public static final String INFO = "INFO";
        public static final String SUCCESS = "SUCCESS";
    }

    public static class UserMessage {
        public static final String DATA_CREATED = "DATA_CREATED";
        public static final String DATA_RETRIEVED = "DATA_RETRIEVED";
        public static final String DATA_UPDATED = "DATA_UPDATED";
        public static final String DATA_DELETED = "DATA_DELETED";
    }
}
