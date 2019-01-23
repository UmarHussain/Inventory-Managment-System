package com.okta.developer.ims.utils.constants;

public class Constants {
	public static final Integer ENABLED = 1;
    public static final Integer DISABLED = 0;

    public static class ErrorMessage {
        public static final String MANDATORY_DATA = "MANDATORY_DATA";
        public static final String DUPLICATE_DATA = "DUPLICATE_DATA";
    }

    public static class ModelFields {
        public static final String INVENTORY_NAME = "name";
        public static final String INVENTORY_QUANTITY = "quantity";
        public static final String INVENTORY_TYPE = "inventoryType";
        public static final String USER_NAME = "userName";
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

    public static class ModelSQLFields {
        public static final String INVENTORY_NAME = "name";
        public static final String INVENTORY_QUANTITY = "quantity";
        public static final String INVENTORY_TYPE = "type";
        public static final String INVENTORY_ENABLED = "enabled";
    }
}
