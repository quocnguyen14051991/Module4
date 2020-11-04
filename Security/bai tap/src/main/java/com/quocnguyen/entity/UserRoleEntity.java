package com.quocnguyen.entity;

import javax.persistence.*;

@Entity
@Table(name = "User_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = {"User_Id", "Role_Id"})})
public class UserRoleEntity {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "User_id", nullable = false)
    private UserEntity userEntity;

    @ManyToOne()
    @JoinColumn(name = "Role_id",nullable = false)
    private RoleEntity roleEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
