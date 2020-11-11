package com.example.keystudy.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;


@Entity
@Table(name = "customer")
public class Customer implements Validator {
    @Id
    @Column(name = "customer_id")
    private String customer_id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_birthday")
    private String customerBirthday;

    @Column(name = "customer_gender")
    private Integer CustomerGender;

    @Column(name = "customer_id_card")
    private String customerIdCard;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;

    @ManyToOne()
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(String customer_id, String customerName, String customerBirthday, Integer customerGender,
                    String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customer_id = customer_id;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        CustomerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        CustomerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;

        String idCustomer = customer.getCustomer_id();
        String phoneCustomer=customer.getCustomerPhone();
        String idCardCustomer=customer.getCustomerIdCard();
        String emailCustomer=customer.getCustomerEmail();
        if (idCustomer.equals("")) {
            errors.rejectValue("customer_id", "customer.id.empty");
        }
        if(!idCustomer.matches("^KH-[\\d]{4}"))
        {
            errors.rejectValue("customer_id","customer.valid");
        }
        if(phoneCustomer.equals(""))
        {
            errors.rejectValue("customerPhone","customer.phone.empty");
        }
        if(!phoneCustomer.matches("^(090|091|[(]84[)][+]90|[(]84[)][+]91)[\\d]{7}$"))
        {
            errors.rejectValue("customerPhone","customer.phone.valid");
        }
        if(idCardCustomer.equals(""))
        {
            errors.rejectValue("customerIdCard","customer.idCard.empty");
        }
        if(!idCardCustomer.matches("^[\\d]{9}$"))
        {
            errors.rejectValue("customerIdCard","customer.idCard.valid");
        }
        if(emailCustomer.equals(""))
        {
            errors.rejectValue("customerEmail","customer.email.empty");
        }
        if(!emailCustomer.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
        {
            errors.rejectValue("customerEmail","customer.email.valid");
        }

    }
}
