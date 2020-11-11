package com.quocnguyen.repository;

import com.quocnguyen.entyti.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String userName);
}
