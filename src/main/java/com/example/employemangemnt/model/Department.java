package com.example.employemangemnt.model;

import javax.persistence.*;
import javax.persistence.Table;

import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name= "department" ,uniqueConstraints={@UniqueConstraint(columnNames="dept_name")})

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dept_id;
    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employees = new LinkedList<>();


    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
