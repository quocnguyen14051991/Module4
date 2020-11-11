package com.example.keystudy.service.impl;

import com.example.keystudy.entity.user.UserRole;
import com.example.keystudy.repository.UserRoleRepository;
import com.example.keystudy.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll() {
        return this.userRoleRepository.findAll();
    }

    @Override
    public void save(UserRole userRole) {
        this.userRoleRepository.save(userRole);
    }

    @Override
    public void delete(UserRole userRole) {
        this.userRoleRepository.delete(userRole);
    }

    @Override
    public UserRole findById(Integer id) {

        return this.userRoleRepository.findById(id).orElse(null);
    }
}
