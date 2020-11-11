package com.quocnguyen.service;

import com.quocnguyen.entyti.AppUser;
import com.quocnguyen.entyti.UserRole;
import com.quocnguyen.repository.AppUserRepository;
import com.quocnguyen.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailService implements UserDetailsService {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(username);
        if (appUser == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);
        List<UserRole> userRoles = this.userRoleRepository.findByAppUser(appUser);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (userRoles != null) {
            for (UserRole userrole : userRoles) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userrole.getAppRole().getRoleName());
                grantList.add(grantedAuthority);
            }
        }
        UserDetails userDetails = new User(appUser.getUserName(), appUser.getEncrytedPassword(), grantList);
        return userDetails;
    }
}
