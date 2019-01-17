package com.okta.developer.ims.service;

import com.okta.developer.ims.dto.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public UserDTO updateUser(UserDTO userDTO);

    public UserDTO getUser(Integer id);

    public UserDTO deleteUser(UserDTO userDTO);

    public Boolean authenticateUser(UserDTO userDTO);
}
