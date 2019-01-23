package com.okta.developer.ims.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private Integer userId;

    @NotNull(message = "ApplcationUser Name can not be null")
    @NotBlank(message = "ApplcationUser Name can not be Empty")
    private String userName;

    @NotNull(message = "Password can not be null")
    @NotBlank(message = "Password can not be Empty")
    private String password;

    @NotNull(message = "ApplcationUser Role can not be null")
    @NotBlank(message = "ApplcationUser Role can not be Empty")
    private String userRole;
}
