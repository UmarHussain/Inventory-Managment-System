package com.okta.developer.ims.service;

import com.okta.developer.ims.dto.UserDTO;
import com.okta.developer.ims.exception.ServiceException;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO) throws ServiceException;

    public UserDTO updateUser(UserDTO userDTO);

    public UserDTO getUser(Integer id);

    public UserDTO deleteUser(UserDTO userDTO);

    public Boolean authenticateUser(UserDTO userDTO);
}
