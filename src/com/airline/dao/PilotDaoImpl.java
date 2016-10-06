package com.airline.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Pilot;

/**
 * Session Bean implementation class PilotDaoImpl
 */
@Stateless
public class PilotDaoImpl implements PilotDao {

    @PersistenceContext( unitName = "airline" )
    private EntityManager em;

    /**
     * Default constructor.
     */
    public PilotDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Pilot> getAllPilots() {
        TypedQuery<Pilot> query = em.createQuery( "SELECT p FROM Pilot p", Pilot.class );
        List<Pilot> results = query.getResultList();

        return results;
    }

    @Override
    public Pilot getPilotById( String pilotId ) {
        TypedQuery<Pilot> pQuery = em.createNamedQuery( "Pilot.findById", Pilot.class );
        pQuery.setParameter( "id", Integer.parseInt( pilotId ) );
        Pilot pilot = pQuery.getSingleResult();
        return pilot;

    }

    @Override
    public void createPilot( Pilot pilot ) {
        em.persist( pilot );

    }
}
