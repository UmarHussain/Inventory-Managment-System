package com.okta.developer.ims.service.impl;

import com.okta.developer.ims.model.ApplcationUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.okta.developer.ims.repository.UserRepository;
import com.okta.developer.ims.utils.constants.Constants;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ApplcationUser applicationUser = userRepository.findByUserNameAndEnabled(userName, Constants.ENABLED);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new User(applicationUser.getUserName(), applicationUser.getPassword(), Collections.emptyList());
    }
}
