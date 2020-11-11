package com.quocnguyen.repository;

import com.quocnguyen.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserEntitiesByUserName(String userName);
}
