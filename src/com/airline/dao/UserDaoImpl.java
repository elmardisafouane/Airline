package com.airline.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.models.User;

/**
 * Session Bean implementation class UserDaoImpl
 */
@Stateless
public class UserDaoImpl implements UserDao {

    @PersistenceContext( unitName = "airline" )
    private EntityManager em;

    /**
     * Default constructor.
     */
    public UserDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public User getUser( String username, String password ) {
        try {
            TypedQuery<User> uQuery = em.createNamedQuery( "User.findByUsername", User.class );
            uQuery.setParameter( "userneme", username );
            uQuery.setParameter( "password", password );
            User user = uQuery.getSingleResult();
            return user;
        } catch ( NoResultException e ) {
            return null;
        }

    }

    @Override
    public void createUser( User user ) {
        em.persist( user );

    }

}
