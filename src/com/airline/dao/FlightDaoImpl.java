package com.airline.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Flight;
import com.airline.models.Passenger;

/**
 * Session Bean implementation class FlightDaoImpl
 */
@Stateless
public class FlightDaoImpl implements FlightDao {

    @PersistenceContext( unitName = "airline" )
    private EntityManager em;

    /**
     * Default constructor.
     */
    public FlightDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void createFlight( Flight f ) {
        em.persist( f );
    }

    @Override
    public Flight getFlightById( String flightId ) {
        TypedQuery<Flight> fQuery = em.createNamedQuery( "Flight.findById", Flight.class );
        fQuery.setParameter( "id", Integer.parseInt( flightId ) );
        Flight flight = null;
        try {
            flight = fQuery.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        }

        return flight;
    }

    @Override
    public List<Flight> getAllFlights() {
        TypedQuery<Flight> query = em.createQuery( "SELECT f FROM Flight f", Flight.class );
        List<Flight> results = query.getResultList();

        return results;
    }

    @Override
    public void removeFlight( Flight flight ) {
        em.remove( em.contains( flight ) ? flight : em.merge( flight ) );
        for ( Passenger passenger : flight.getPassengers() ) {
            passenger.getFlights().remove( flight );
        }

    }

    @Override
    public void updateFlight( Flight flight ) {
        // TODO Auto-generated method stub

    }

}
