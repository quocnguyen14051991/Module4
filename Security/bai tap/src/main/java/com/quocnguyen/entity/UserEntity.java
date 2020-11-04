package com.quocnguyen.entity;

import javax.persistence.*;

@Entity
@Table(name = "usere", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "username") })
public class UserEntity extends BaseEntity {

    @Column(name = "username",nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String password;


    @Column(name = "fullname",nullable =false,length = 256)
    private String fullName;

    @Column(name = "status", length = 1, nullable = false)
    private String status;

    public UserEntity() {
    }

    public UserEntity(String userName, String password, String fullName, String status) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
