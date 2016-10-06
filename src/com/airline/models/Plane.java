package com.airline.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Plane
 * 
 */
@NamedQuery( name = "Plane.findById", query = "SELECT p FROM Plane p WHERE p.id = :id" )
@Entity
public class Plane implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    public Plane() {
        super();
    }

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer id;

    private String  Model;
    private String  Capacity;

    @OneToOne( mappedBy = "airplane" )
    private Flight  flight;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel( String model ) {
        Model = model;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity( String capacity ) {
        Capacity = capacity;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight( Flight flight ) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Plane [id=" + id + ", Model=" + Model + ", Capacity=" + Capacity + ", flight=" + flight + "]";
    }

}
