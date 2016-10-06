package com.airline.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Flight
 * 
 */
@NamedQuery( name = "Flight.findById", query = "SELECT f FROM Flight f WHERE f.id = :id" )
@Entity
public class Flight implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    public Flight() {
        super();
    }

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer         id;

    @Enumerated( EnumType.STRING )
    private Cities          depart;

    @Enumerated( EnumType.STRING )
    private Cities          destination;

    private String          prix;

    @Temporal( TemporalType.TIMESTAMP )
    private Date            date;

    @ManyToMany( cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH } )
    @JoinTable( name = "f_p_join", joinColumns = @JoinColumn( name = "flight_fk" ), inverseJoinColumns = @JoinColumn( name = "passenger_fk" ) )
    private List<Passenger> passengers;

    @OneToOne( )
    @JoinColumn( name = "airplane_fk" )
    private Plane           airplane;

    @OneToOne( )
    @JoinColumn( name = "pilot_fk" )
    private Pilot           pilot;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Cities getDepart() {
        return depart;
    }

    public void setDepart( Cities depart ) {
        this.depart = depart;
    }

    public Cities getDestination() {
        return destination;
    }

    public void setDestination( Cities destination ) {
        this.destination = destination;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix( String prix ) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers( List<Passenger> passengers ) {
        this.passengers = passengers;
    }

    public Plane getAirplane() {
        return airplane;
    }

    public void setAirplane( Plane airplane ) {
        this.airplane = airplane;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot( Pilot pilot ) {
        this.pilot = pilot;
    }

    @Override
    public String toString() {
        return "Flight [id=" + id + ", depart=" + depart + ", destination=" + destination + ", prix=" + prix
                + ", date=" + date + ", passengers=" + passengers + ", airplane=" + airplane + ", pilot=" + pilot + "]";
    }

}
