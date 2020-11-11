package com.example.keystudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "postion")
public class PositionEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer idPosition;

    @Column(name = "postion_name")
    private String namePosition;

    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    List<Employee> employees;


    public PositionEmployee() {
    }

    public PositionEmployee(Integer idPosition, String namePosition) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
    }

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
