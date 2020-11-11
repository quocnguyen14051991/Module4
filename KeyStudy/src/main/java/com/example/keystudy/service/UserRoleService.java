package com.example.keystudy.service;

import com.example.keystudy.entity.user.UserEntity;
import com.example.keystudy.entity.user.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findAll();
    void save(UserRole userRole);
    void delete(UserRole UserRole);
    UserRole findById(Integer id);
}
