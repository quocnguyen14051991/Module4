package com.quocnguyen.service;

import com.quocnguyen.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEntityService {
    List<UserEntity> findAllUserEntity();
    UserEntity findByUsername(String userName);

}
