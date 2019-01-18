package com.okta.developer.ims.controller;

import com.okta.developer.ims.dto.ClientResponse;
import com.okta.developer.ims.dto.UserDTO;
import com.okta.developer.ims.exception.BaseException;
import com.okta.developer.ims.exception.ServiceException;
import com.okta.developer.ims.service.UserService;
import com.okta.developer.ims.utils.factory.ClientResponseFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static com.okta.developer.ims.utils.Constants.UserMessage.DATA_CREATED;

@CrossOrigin
@RestController
@RequestMapping("/userService/v1")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/create")
    ClientResponse<UserDTO> createInventory(@RequestBody @Valid UserDTO userDTO) throws BaseException {
        LOGGER.info("Creating User");
        return Optional.ofNullable(userDTO)
                .map(user -> {
                    try {
                        return userService.createUser(user);
                    } catch (ServiceException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(response -> ClientResponseFactory.getClientResponse(DATA_CREATED, response))
                .get();
    }
}
