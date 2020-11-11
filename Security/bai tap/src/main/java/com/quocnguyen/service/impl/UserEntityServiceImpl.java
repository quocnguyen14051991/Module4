package com.quocnguyen.service.impl;

import com.quocnguyen.entity.UserEntity;
import com.quocnguyen.repository.UserEntityRepository;
import com.quocnguyen.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    UserEntityRepository userEntityRepository;
    @Override
    public List<UserEntity> findAllUserEntity() {
        return userEntityRepository.findAll();
    }

    @Override
    public UserEntity findByUsername(String userName) {
        return userEntityRepository.findUserEntitiesByUserName(userName);
    }
}
