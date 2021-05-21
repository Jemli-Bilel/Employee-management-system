package com.example.employemangemnt.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.persistence.Table;



@Entity
@Table(name= "employees")
public class Employee {





     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     @Column(name = "firstname")
    private String firstname;
     @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @Column(name="status")
    private String status;

    public String getStatus() {
        return status;
    }
    public void setStatus( String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
