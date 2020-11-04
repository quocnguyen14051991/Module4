package com.quocnguyen.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category_blog")
public class CategoryEntity extends BaseEntity implements Validator {

    private String nameCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<DigitalEntity> digitalList;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<DigitalEntity> getDigitalList() {
        return digitalList;
    }

    public void setDigitalList(List<DigitalEntity> digitalList) {
        this.digitalList = digitalList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoryEntity category = (CategoryEntity) target;
        if (category.nameCategory.equals("")) {
            errors.rejectValue("nameCategory", "name.empty");
        }
    }
}
