package org.acme.service;

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

    public UserEntity updateUser(UUID userId, UserEntity userEntity) {
        var user = findById(userId);
        user.username = userEntity.username;
        UserEntity.persist(user);
        return user;
    }

    public void deleteById(UUID userId) {
        var user = findById(userId);
        UserEntity.deleteById(user.userId);
    }
}
