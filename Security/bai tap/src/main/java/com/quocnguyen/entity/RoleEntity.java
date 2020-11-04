package com.quocnguyen.entity;

import javax.persistence.*;

@Entity
@Table(name = "role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "ROLE_UK", columnNames = "name")})
public class RoleEntity extends BaseEntity {

    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "code")
    private String code;

    public RoleEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
