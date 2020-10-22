package com.quocnguyen.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "provice")
public class Provice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proviceId;
    private String name;
    @OneToMany(mappedBy = "provice",cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public Provice() {
    }

    public Provice(Long proviceId, String name) {
        this.proviceId = proviceId;
        this.name = name;
    }

    public Long getProviceId() {
        return proviceId;
    }

    public void setProviceId(Long proviceId) {
        this.proviceId = proviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
