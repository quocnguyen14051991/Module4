package com.example.keystudy.entity.employee;

import com.example.keystudy.entity.user.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_birthday")
    private String employeeBirthday;

    @Column(name = "employee_id_card")
    private String employeeIDCard;

    @Column(name = "employee_salary")
    private String employeeSalary;

    @Column(name = "employee_phone")
    private String employeePhone;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_address")
    private String employeeAddress;

    @ManyToOne()
    @JoinColumn(name = "id_division", referencedColumnName = "division_id")
    private Division division;

    @ManyToOne()
    @JoinColumn(name = "id_education_degree", referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne()
    @JoinColumn(name = "id_position", referencedColumnName = "position_id")
    private PositionEmployee position;

    @OneToOne
    @JoinColumn(name = "username_employee", referencedColumnName = "username")
    @JsonBackReference
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Employee(Integer employeeId, String employeeName, String employeeBirthday, String employeeIDCard,
                    String employeeSalary, String employeePhone, String employeeEmail, String employeeAddress) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIDCard = employeeIDCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
    }

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIDCard() {
        return employeeIDCard;
    }

    public void setEmployeeIDCard(String employeeIDCard) {
        this.employeeIDCard = employeeIDCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public PositionEmployee getPosition() {
        return position;
    }

    public void setPosition(PositionEmployee position) {
        this.position = position;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        String salaryEmployee = employee.getEmployeeSalary();
        if(salaryEmployee.equals(""))
        {
            errors.rejectValue("employeeSalary","employee.salary.empty");
        }
        if(!salaryEmployee.matches("^([1-9][\\d]*(\\.[\\d]*)?)|(0\\.[\\d]+)$"))
        {
            errors.rejectValue("employeeSalary","employee.salary.valid");
        }
    }
}
