package com.example.keystudy.entity.user;

import com.example.keystudy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = { //
        @UniqueConstraint(name = "APP_USER_UK", columnNames = "username")})
public class UserEntity {
    @Id
    @Column(name = "username",nullable = true)
    private String username;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @OneToOne(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private Employee employees;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<UserRole> userRoles;

    public List<UserRole> getUserRoles() {
        return userRoles;
    }


    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee getEmployees() {
        return employees;
    }

    public void setEmployees(Employee employees) {
        this.employees = employees;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
