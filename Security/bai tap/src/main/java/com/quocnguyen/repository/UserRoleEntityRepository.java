package com.quocnguyen.repository;

import com.quocnguyen.entity.UserEntity;
import com.quocnguyen.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity,Integer> {
    List<UserRoleEntity> findByUserEntity(UserEntity userEntity);
}
