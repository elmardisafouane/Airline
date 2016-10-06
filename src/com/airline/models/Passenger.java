package com.airline.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Passenger
 * 
 */
@NamedQuery( name = "Passenger.findById", query = "SELECT p FROM Passenger p WHERE p.id = :id" )
@Entity
@XmlRootElement
public class Passenger implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    public Passenger() {
        super();
    }

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer      id;

    private String       nom;

    private String       prenom;

    private String       adresse;

    private String       telephone;

    private String       email;

    @Enumerated( EnumType.STRING )
    private FlightClass  flightClass;

    @ManyToMany( mappedBy = "passengers" )
    private List<Flight> flights;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass( FlightClass flightClass ) {
        this.flightClass = flightClass;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights( List<Flight> flights ) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", telephone="
                + telephone + ", email=" + email + ", flightClass=" + flightClass + ", flights=" + flights + "]";
    }

}
