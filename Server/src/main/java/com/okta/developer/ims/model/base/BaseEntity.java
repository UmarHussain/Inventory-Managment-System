package com.okta.developer.ims.model.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "created_time")
    private Timestamp createdTime;

    @Column(name = "updated_time")
    private Timestamp updatedTime;

    @PrePersist
    void onCreate() {
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.updatedTime = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    void onUpdate() {
        this.updatedTime = new Timestamp(System.currentTimeMillis());
    }
}
