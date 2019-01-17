package com.okta.developer.ims.service.impl;

import com.okta.developer.ims.dto.UserDTO;
import com.okta.developer.ims.repository.UserRepository;
import com.okta.developer.ims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO getUser(Integer id) {
        return null;
    }

    @Override
    public UserDTO deleteUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean authenticateUser(UserDTO userDTO) {
        return null;
    }
}
