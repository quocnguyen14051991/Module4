package com.quocnguyen.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sun.util.calendar.BaseCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity(name = "user")
public class UserRegex implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String firstsNameUser;
    private String lastNameUser;
    private String phoneNumberUser;
    private String ageUser;
    private String emailUser;

    public UserRegex() {
    }

    public UserRegex(Integer idUser, String firstsNameUser, String lastNameUser, String phoneNumberUser, String ageUser, String emailUser) {
        this.idUser = idUser;
        this.firstsNameUser = firstsNameUser;
        this.lastNameUser = lastNameUser;
        this.phoneNumberUser = phoneNumberUser;
        this.ageUser = ageUser;
        this.emailUser = emailUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstsNameUser() {
        return firstsNameUser;
    }

    public void setFirstsNameUser(String firstsNameUser) {
        this.firstsNameUser = firstsNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    public String getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(String ageUser) {
        this.ageUser = ageUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegex userRegex = (UserRegex) target;
        String firstsNameUser = userRegex.getFirstsNameUser();
        String lastNameUser = userRegex.getLastNameUser();
        String phone = userRegex.getPhoneNumberUser();
        String age = userRegex.getAgeUser();
        String emailUser = userRegex.getEmailUser();

        int yearDateOfBirth = 0;
        int mothDateOfBirth=0;
        int dayDateOfBirth=0;
        String[] dateOfBirthUser = age.split("-");
        try {
            yearDateOfBirth = Integer.parseInt(dateOfBirthUser[0]);
            mothDateOfBirth = Integer.parseInt(dateOfBirthUser[1]);
            dayDateOfBirth = Integer.parseInt(dateOfBirthUser[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Date curDate = new Date();
        int mothCurDate = curDate.getMonth() + 1;
        int yearCurDate = curDate.getYear() + 1900;
        int dayCurDate = curDate.getDate();

        if (yearCurDate - yearDateOfBirth < 18) {
            errors.rejectValue("ageUser", "userReg.ageUser.valid");
        }

        if (yearCurDate - yearDateOfBirth == 18) {
            if (mothCurDate < mothDateOfBirth) {
                errors.rejectValue("ageUser", "userReg.ageUser.valid");
            }
            if (mothCurDate == mothDateOfBirth) {
                if (dayCurDate < dayDateOfBirth)
                    errors.rejectValue("ageUser", "userReg.ageUser.valid");
            }
        }

        if (firstsNameUser.equals("")) {
            errors.rejectValue("firstsNameUser", "userReg.firstsName.empty");
        }

        if (!firstsNameUser.matches("^[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,20}$")) {
            errors.rejectValue("firstsNameUser", "userReg.firstName.valid");
        }

        if (!lastNameUser.matches("^[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,20}$")) {
            errors.rejectValue("lastNameUser", "userReg.lastName.valid");
        }

        if (lastNameUser.equals("")) {
            errors.rejectValue("lastNameUser", "userReg.lastName.empty");
        }

        if (!(firstsNameUser.length() >= 5 && firstsNameUser.length() <= 45)) {
            errors.rejectValue("firstsNameUser", "userReg.firstName.length");
        }

        if (!(lastNameUser.length() >= 5 && lastNameUser.length() <= 45)) {
            errors.rejectValue("lastNameUser", "userReg.lastName.length");
        }

        if (!emailUser.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")) {
            errors.rejectValue("emailUser", "userReg.email.notRegex");
        }
        if (!phone.matches("(09|01[2|6|8|9])+([0-9]{8})")) {
            errors.rejectValue("phoneNumberUser", "userReg.phone.notRegex");
        }
//        if(age.matches("^(((0|1)[0-9]|2[0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\/((19|20)\\d\\d))$")){
//
//        }
    }
}
