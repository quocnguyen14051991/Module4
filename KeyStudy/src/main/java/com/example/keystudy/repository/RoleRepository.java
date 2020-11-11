package com.example.keystudy.repository;

import com.example.keystudy.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Integer> {
    Role findByRoleName(String roleName);
}
