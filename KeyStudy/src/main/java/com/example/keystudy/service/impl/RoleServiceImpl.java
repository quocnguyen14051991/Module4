package com.example.keystudy.service.impl;

import com.example.keystudy.entity.user.Role;
import com.example.keystudy.repository.RoleRepository;
import com.example.keystudy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public void delete(Role Role) {
        this.roleRepository.delete(Role);
    }

    @Override
    public Role findById(Integer id) {
        return this.roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role findByName(String name) {
        return this.roleRepository.findByRoleName(name);
    }
}
