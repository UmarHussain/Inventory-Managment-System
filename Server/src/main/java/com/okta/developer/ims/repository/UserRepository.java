package com.okta.developer.ims.repository;

import com.okta.developer.ims.model.User;
import com.okta.developer.ims.repository.base.BaseRepository;


public interface UserRepository extends BaseRepository<User, Long> {
    User findByUserNameAndEnabled(String userName, Integer enabled);
}
