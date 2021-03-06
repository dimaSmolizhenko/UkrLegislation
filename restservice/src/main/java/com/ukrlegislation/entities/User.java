package com.ukrlegislation.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by dima on 7/17/15.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private long id;

    private String login;

    private String  password;

    @Column(name ="full_name")
    private String fullName;

    @Column(name = "register_date")
    private Date registrationDate;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(){
    }

    public User(String login, String password, String fullName, Date registrationDate, Role role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", registrationDate=" + registrationDate +
                ", role='" + role + '\'' +
                '}';
    }
}
