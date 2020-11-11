package com.example.keystudy.service;

import com.example.keystudy.entity.user.Role;
import com.example.keystudy.entity.user.UserRole;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    void save(Role role);
    void delete(Role Role);
    Role findById(Integer id);
    Role findByName(String name);
}
