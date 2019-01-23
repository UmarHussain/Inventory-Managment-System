package com.okta.developer.ims.repository;

import com.okta.developer.ims.model.ApplcationUser;
import com.okta.developer.ims.repository.base.BaseRepository;


public interface UserRepository extends BaseRepository<ApplcationUser, Long> {
    ApplcationUser findByUserNameAndEnabled(String userName, Integer enabled);
}
