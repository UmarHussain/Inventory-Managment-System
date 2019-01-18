package com.okta.developer.ims.service.impl;

import com.okta.developer.ims.dto.UserDTO;
import com.okta.developer.ims.exception.ServiceException;
import com.okta.developer.ims.model.User;
import com.okta.developer.ims.model.UserRole;
import com.okta.developer.ims.repository.UserRepository;
import com.okta.developer.ims.repository.UserRoleRepository;
import com.okta.developer.ims.service.UserService;
import com.okta.developer.ims.utils.Adapter;
import com.okta.developer.ims.utils.Constants;
import com.okta.developer.ims.utils.Constants.ModelFields;

import com.okta.developer.ims.utils.validation.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.okta.developer.ims.utils.Constants.ErrorMessage.DUPLICATE_DATA;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws ServiceException {
        User user = userRepository.findByUserNameAndEnabled(userDTO.getUserName(), Constants.ENABLED);
        validateUserCreated(user);
        UserRole userRole = userRoleRepository.findByUserRoleAndEnabled(userDTO.getUserRole(), Constants.ENABLED);
        return Optional.ofNullable(userDTO)
                       .map(e -> Adapter.getInstance().convert(e, User.class))
                       .map(e -> {
                             e.setUserRole(userRole);
                             e.setPassword(UserUtil.hashPassword(e.getPassword()));
                             e.setEnabled(Constants.ENABLED);
                             return userRepository.save(e); })
                       .map(e -> Adapter.getInstance().convert(e, UserDTO.class))
                       .get();
    }

    private void validateUserCreated(User user) throws ServiceException {
        if (user != null) {
            throw new ServiceException(DUPLICATE_DATA, new String[]{ModelFields.USER_NAME});
        }
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
