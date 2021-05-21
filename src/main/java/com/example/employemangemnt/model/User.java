package com.example.employemangemnt.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Idu;

    @Column(name="Mail")
    private String Mail;

    @Column(name="Password")
    private String Password;

    public Long getIdu() {
        return Idu;
    }

    public void setIdu(Long idu) {
        Idu = idu;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
