package com.airline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: User
 * 
 */
@NamedQuery( name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :userneme AND u.password = :password" )
@Entity
@Table( name = "Utilisateur" )
public class User implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    public User() {
        super();
    }

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;

    private String  username;
    private String  password;

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

}
