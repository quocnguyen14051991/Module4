package com.example.keystudy.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "User_Role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_role")
    private Integer id_role_user;


    @ManyToOne()
    @JoinColumn(name = "Role_Id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "usernamee")
    private UserEntity userEntity;

    public UserRole() {
    }


    public Integer getId_role_user() {
        return id_role_user;
    }

    public void setId_role_user(Integer id_role_user) {
        this.id_role_user = id_role_user;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
