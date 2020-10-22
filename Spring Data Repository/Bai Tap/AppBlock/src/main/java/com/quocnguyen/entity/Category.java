package com.quocnguyen.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category_blog")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;
    private String nameCategory;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Digital> digitalList;

    public Category() {
    }

    public Category(Integer idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Digital> getDigitalList() {
        return digitalList;
    }

    public void setDigitalList(List<Digital> digitalList) {
        this.digitalList = digitalList;
    }
}
