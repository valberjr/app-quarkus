package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.controller.entity.UserEntity;

@ApplicationScoped
public class UserService {

    public UserEntity createUser(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }
}
