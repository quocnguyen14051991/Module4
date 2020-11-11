package com.example.keystudy.service;

import com.example.keystudy.entity.user.UserEntity;

import java.util.List;

public interface UserEntityService {
    List<UserEntity> findAll();
    void save(UserEntity userEntity);
    void delete(UserEntity userEntity);
    UserEntity findById(Integer id);
}
