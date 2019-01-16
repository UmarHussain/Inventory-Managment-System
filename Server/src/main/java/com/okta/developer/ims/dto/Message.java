package com.okta.developer.ims.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * A Message CDD uses attributes:
 * <b>id</b>:would be useful when we need to get Message from DB
 * <b>key</b>: Message key thats need to be displayed
 * <b>description</b>: Message description thats need to be displayed
 * <b>type</b>: Message type thats need to be displayed
 *
 * @author  mwasif
 */
@Data
public class Message implements Serializable {
    private int id;  // will use only when we need to get Message from DB
    private String key;
    private String description;
    private String type;

    public Message() {
    }

    public Message(String key, String description) {
        this.key = key;
        this.description = description;
    }

    public Message(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Message(int id, String key, String description) {
        this.id = id;
        this.key = key;
        this.description = description;
    }

    public Message(String key, String description, String type) {
        this.key = key;
        this.description = description;
        this.type = type;
    }
}
