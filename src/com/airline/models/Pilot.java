package com.airline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Pilot
 * 
 */
@NamedQuery( name = "Pilot.findById", query = "SELECT p FROM Pilot p WHERE p.id = :id" )
@Entity
public class Pilot implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    public Pilot() {
        super();
    }

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer   id;

    private String    nom;
    private String    prenom;
    private String    license;

    @Enumerated( EnumType.STRING )
    private PilotRank pilotRank;

    @OneToOne( mappedBy = "pilot" )
    private Flight    flight;

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

    public String getLicense() {
        return license;
    }

    public void setLicense( String license ) {
        this.license = license;
    }

    public PilotRank getPilotRank() {
        return pilotRank;
    }

    public void setPilotRank( PilotRank pilotRank ) {
        this.pilotRank = pilotRank;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight( Flight flight ) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Pilot [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", license=" + license + ", pilotRank="
                + pilotRank + ", flight=" + flight + "]";
    }

}
