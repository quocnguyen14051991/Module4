package com.quocnguyen.service.impl;

import com.quocnguyen.repository.RoleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleEntityServiceImpl {
    @Autowired
    RoleEntityRepository roleEntityRepository;

}
