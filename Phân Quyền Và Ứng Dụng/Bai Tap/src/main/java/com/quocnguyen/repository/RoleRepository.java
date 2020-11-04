package com.quocnguyen.repository;

import com.quocnguyen.entyti.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String role_admin);
}
