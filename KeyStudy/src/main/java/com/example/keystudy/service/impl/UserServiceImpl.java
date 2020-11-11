package com.example.keystudy.service.impl;

import com.example.keystudy.entity.user.UserEntity;
import com.example.keystudy.repository.UserEntityRepository;
import com.example.keystudy.repository.UserRoleRepository;
import com.example.keystudy.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserEntityService {
    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public List<UserEntity> findAll() {
        return this.userEntityRepository.findAll();
    }

    @Override
    public void save(UserEntity userEntity) {
        this.userEntityRepository.save(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        this.userEntityRepository.delete(userEntity);
    }

    @Override
    public UserEntity findById(Integer id) {
        return this.userEntityRepository.findById(id).orElse(null);
    }
}
