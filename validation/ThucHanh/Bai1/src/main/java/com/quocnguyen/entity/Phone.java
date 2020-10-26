package com.quocnguyen.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "phoneNumber")
public class Phone implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String number;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Phone phone = (Phone) target;
        String numberPhone = phone.getNumber();
        if (numberPhone.equals("")) {
                errors.rejectValue("number", "number.empty");
        }
        if (numberPhone.length() > 11 || numberPhone.length() < 10) {
            errors.rejectValue("number", "number.length");
        }
        if(!numberPhone.startsWith("0")){
            errors.rejectValue("number","number.startsWith");
        }
        if(!numberPhone.matches("^$|[0-9]*$")){
            errors.rejectValue("number","number.matches");
        }

    }


}
