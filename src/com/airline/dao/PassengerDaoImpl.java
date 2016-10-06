package com.airline.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Passenger;

/**
 * Session Bean implementation class PassengerDaoImpl
 */
@Stateless
public class PassengerDaoImpl implements PassengerDao {

    /**
     * Default constructor.
     */
    public PassengerDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext( unitName = "airline" )
    private EntityManager em;

    @Override
    public Passenger createPassenger( Passenger p ) {

        em.persist( p );
        return p;

    }

    @Override
    public Passenger getPassengerById( String passengerId ) {
        TypedQuery<Passenger> pQuery = em.createNamedQuery( "Passenger.findById", Passenger.class );
        pQuery.setParameter( "id", Integer.parseInt( passengerId ) );
        Passenger passenger = null;
        try {
            passenger = pQuery.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        }

        return passenger;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        TypedQuery<Passenger> query = em.createQuery( "SELECT p FROM Passenger p", Passenger.class );
        List<Passenger> pList = query.getResultList();
        return pList;
    }

    @Override
    public void removePassenger( Passenger passenger ) {
        em.remove( em.contains( passenger ) ? passenger : em.merge( passenger ) );

    }

    @Override
    public void updatePassenger( Passenger passenger ) {
        // TODO Auto-generated method stub

    }

}
