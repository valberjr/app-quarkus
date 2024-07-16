package org.acme.service;

import io.vertx.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.controller.entity.UserEntity;
import org.acme.exception.UserNotFoundException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public UserEntity createUser(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> findAll(Integer page, Integer pageSize) {
        return UserEntity.findAll()
                .page(page, pageSize)
                .list();
    }

    public UserEntity findById(UUID userId) {
        return (UserEntity) UserEntity
                .findByIdOptional(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
