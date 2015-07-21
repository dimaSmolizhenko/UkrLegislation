package com.ukrlegislation.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ramax on 7/21/15.
 */
public class User implements Serializable{

    @Id
    private Integer id;
    private String login;
    private String password;
    private Date registrationDate;
    private String role;

    public User() {
    }

    public User(Integer id, String login, String password, Date registrationDate, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
