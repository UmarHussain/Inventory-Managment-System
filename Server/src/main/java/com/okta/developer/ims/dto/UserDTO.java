package com.okta.developer.ims.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private Integer userId;
    private String userName;
    private String password;
    private String userRole;
}
