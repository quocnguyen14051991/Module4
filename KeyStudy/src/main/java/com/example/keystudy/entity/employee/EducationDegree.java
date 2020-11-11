package com.example.keystudy.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer idEducationDegree;

    @Column(name = "education_degree_name")
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    private List<Employee> employees;
    public EducationDegree() {
    }

    public EducationDegree(Integer idEducationDegree, String educationDegreeName) {
        this.idEducationDegree = idEducationDegree;
        this.educationDegreeName = educationDegreeName;
    }

    public Integer getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(Integer idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
