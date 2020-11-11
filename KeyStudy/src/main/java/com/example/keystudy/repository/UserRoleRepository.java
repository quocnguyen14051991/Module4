package com.example.keystudy.repository;

import com.example.keystudy.entity.user.UserEntity;
import com.example.keystudy.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findByUserEntity(UserEntity userEntity);
}
