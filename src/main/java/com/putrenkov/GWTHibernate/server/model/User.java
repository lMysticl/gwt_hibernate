package com.putrenkov.GWTHibernate.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userdb")
@NamedQuery(name = "User.findUserByLogin", query = "SELECT u FROM User u WHERE u.login = :login")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long user_id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    public User() {
	super();
    }

    public User(String login, String password, String firstName) {
	super();
	this.login = login;
	this.password = password;
	this.firstName = firstName;
    }

    @Override
    public String toString() {
	return login + "  " + password + "  " + firstName;

    }

    public Long getUser_id() {
	return user_id;
    }

    public void setUser_id(Long user_id) {
	this.user_id = user_id;
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

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

}
