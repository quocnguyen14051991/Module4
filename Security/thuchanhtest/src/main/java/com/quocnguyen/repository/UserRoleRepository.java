package com.quocnguyen.repository;

import com.quocnguyen.entyti.AppUser;
import com.quocnguyen.entyti.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer>
{
    List<UserRole> findByAppUser(AppUser appUser);
}
