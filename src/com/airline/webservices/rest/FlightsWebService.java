package com.airline.webservices.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.airline.dao.FlightDao;
import com.airline.models.Flight;

@Path( "/flights" )
public class FlightsWebService {

    @PersistenceContext( unitName = "airline" )
    EntityManager entityManager;

    @EJB
    FlightDao     flightDao;

    @Context
    UriInfo       fUriInfo;

    public FlightsWebService() {

    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public List<Flight> getAllFligts() {
        List<Flight> flights = flightDao.getAllFlights();
        return flights;
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Path( "{flight_id}" )
    public Flight getFlightById( @PathParam( "flight_id" ) String flightId ) {
        Flight flight = flightDao.getFlightById( flightId );

        if ( flight == null ) {
            throw new NotFoundException( "The flight with the id " + flightId + "not found" );
        }
        return flight;
    }

}
