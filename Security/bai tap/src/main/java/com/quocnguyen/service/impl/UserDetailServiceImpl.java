package com.quocnguyen.service.impl;

import com.quocnguyen.entity.RoleEntity;
import com.quocnguyen.entity.UserEntity;
import com.quocnguyen.entity.UserRoleEntity;
import com.quocnguyen.repository.RoleEntityRepository;
import com.quocnguyen.repository.UserEntityRepository;
import com.quocnguyen.repository.UserRoleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private  UserEntityRepository userEntityRepository;

    @Autowired
    private UserRoleEntityRepository userRoleEntityRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =userEntityRepository.findUserEntitiesByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<UserRoleEntity> roles = this.userRoleEntityRepository.findByUserEntity(user);
        for (UserRoleEntity role : roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleEntity().getName());
            grantedAuthorities.add(authority);
        }
        UserDetails userDetails = (UserDetails) new User(user.getUserName(), //
                user.getPassword(), grantedAuthorities);

        return userDetails;
    }
}
