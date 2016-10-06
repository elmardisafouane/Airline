package com.airline.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.Plane;

/**
 * Session Bean implementation class PlaneDaoImpl
 */
@Stateless
public class PlaneDaoImpl implements PlaneDao {

    @PersistenceContext( unitName = "airline" )
    private EntityManager em;

    /**
     * Default constructor.
     */
    public PlaneDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Plane> getAllPlanes() {
        TypedQuery<Plane> query = em.createQuery( "SELECT p FROM Plane p", Plane.class );
        List<Plane> results = query.getResultList();

        return results;
    }

    @Override
    public Plane getPlaneById( String planeId ) {
        TypedQuery<Plane> pQuery = em.createNamedQuery( "Plane.findById", Plane.class );
        pQuery.setParameter( "id", Integer.parseInt( planeId ) );
        Plane plane = pQuery.getSingleResult();
        return plane;

    }

    @Override
    public void createPlane( Plane plane ) {
        em.persist( plane );

    }

}
