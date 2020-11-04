package com.quocnguyen.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "create_date")
    private String createDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private String modifiedDate;

    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    @LastModifiedBy
    @Column(name = "modifiedBy")
    private String modifiedBy;

    public Integer getId() {
        return id;
    }

    public String getCreateDate() {
        return createDate;
    }


    public String getModifiedDate() {
        return modifiedDate;
    }


    public String getCreateBy() {
        return createBy;
    }


    public String getModifiedBy() {
        return modifiedBy;
    }


}
