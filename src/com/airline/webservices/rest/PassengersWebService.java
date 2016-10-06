package com.airline.webservices.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.airline.dao.PassengerDao;
import com.airline.models.Passenger;

@Path( "/passengers" )
public class PassengersWebService {

    @PersistenceContext( unitName = "airline" )
    EntityManager entityManager;

    @EJB
    PassengerDao  passengerDao;

    @Context
    UriInfo       pUriInfo;

    public PassengersWebService() {

    }

    @GET
    @Produces( MediaType.APPLICATION_XML )
    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = passengerDao.getAllPassengers();
        return passengers;
    }

    @GET
    @Produces( MediaType.APPLICATION_XML )
    @Path( "{passenger_id}" )
    public Passenger getPassengerById( @PathParam( "passenger_id" ) String passengerId ) {
        Passenger passenger = passengerDao.getPassengerById( passengerId );

        if ( passenger == null ) {
            throw new NotFoundException( "The passenger with id of" + passengerId + "not found" );
        }
        return passenger;
    }

    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    public Response AddPassenger( Passenger passenger ) {
        passengerDao.createPassenger( passenger );
        UriBuilder pUriBuilder = pUriInfo.getAbsolutePathBuilder();
        URI pUri = pUriBuilder.path( String.valueOf( passenger.getId() ) ).build();
        return Response.created( pUri ).build();
    }

}
