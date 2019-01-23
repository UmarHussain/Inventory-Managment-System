package com.okta.developer.ims.service.impl;

import com.okta.developer.ims.dto.UserDTO;
import com.okta.developer.ims.exception.ServiceException;
import com.okta.developer.ims.model.ApplcationUser;
import com.okta.developer.ims.model.UserRole;
import com.okta.developer.ims.repository.UserRepository;
import com.okta.developer.ims.repository.UserRoleRepository;
import com.okta.developer.ims.service.UserService;
import com.okta.developer.ims.utils.Adapter;
import com.okta.developer.ims.utils.constants.Constants;
import com.okta.developer.ims.utils.constants.Constants.ModelFields;

import com.okta.developer.ims.utils.validation.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.okta.developer.ims.utils.constants.Constants.ErrorMessage.DUPLICATE_DATA;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws ServiceException {
        ApplcationUser applcationUser = userRepository.findByUserNameAndEnabled(userDTO.getUserName(), Constants.ENABLED);
        validateUserCreated(applcationUser);
        UserRole userRole = userRoleRepository.findByUserRoleAndEnabled(userDTO.getUserRole(), Constants.ENABLED);
        return Optional.ofNullable(userDTO)
                       .map(e -> Adapter.getInstance().convert(e, ApplcationUser.class))
                       .map(e -> {
                             e.setUserRole(userRole);
                             e.setPassword(UserUtil.hashPassword(e.getPassword()));
                             e.setEnabled(Constants.ENABLED);
                             return userRepository.save(e); })
                       .map(e -> Adapter.getInstance().convert(e, UserDTO.class))
                       .get();
    }

    private void validateUserCreated(ApplcationUser applcationUser) throws ServiceException {
        if (applcationUser != null) {
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
