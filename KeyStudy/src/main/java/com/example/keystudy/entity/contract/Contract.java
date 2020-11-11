package com.example.keystudy.entity.contract;

import com.example.keystudy.entity.customer.Customer;
import com.example.keystudy.entity.employee.Employee;
import com.example.keystudy.entity.service.ServiceFurama;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "contract_start_date")
    private String contractStartDate;

    @Column(name = "contract_end_date")
    private String contractEndDate;

    @Column(name = "contract_deposit")
    private Double contractDeposit;

    @Column(name = "contract_total_money")
    private Double contractTotalMoney;

    @ManyToOne()
    @JoinColumn(name = "service_id")
    private ServiceFurama service;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name ="employee_id")
    private Employee employee;


    public ServiceFurama getService() {
        return service;
    }

    public void setService(ServiceFurama service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Contract() {
    }

    public Contract(Integer contractId, String contractStartDate, String contractEndDate, Double contractDeposit, Double contractTotalMoney) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }
}
