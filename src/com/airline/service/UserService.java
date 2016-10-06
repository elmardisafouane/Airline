package com.airline.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.airline.dao.UserDao;
import com.airline.models.User;

public class UserService {

    private static final String CHAMP_USERNAME   = "username";
    private static final String CHAMP_PASSWORD   = "password";
    private static final String ATT_USER_SESSION = "userSession";

    private String              resultat         = null;
    private UserDao             userDao;

    public String getResultat() {
        return resultat;
    }

    public UserService( UserDao userDao ) {
        this.userDao = userDao;
    }

    private User getUser( String username, String password ) {

        User user = userDao.getUser( username, password );
        return user;
    }

    public void createUser( HttpServletRequest request ) {
        String username = request.getParameter( CHAMP_USERNAME );
        String password = request.getParameter( CHAMP_PASSWORD );

        User user = new User();
        user.setPassword( password );
        user.setUsername( username );

        userDao.createUser( user );
    }

    public void connectUser( HttpServletRequest request ) {
        String username = request.getParameter( CHAMP_USERNAME );
        String password = request.getParameter( CHAMP_PASSWORD );

        User user = getUser( username, password );

        if ( user == null ) {
            resultat = "Non valid credentials !";
            return;
        } else {
            HttpSession session = request.getSession();
            session.setAttribute( ATT_USER_SESSION, user );
            return;
        }
    }

    public void deconnectUser( HttpServletRequest request ) {
        HttpSession session = request.getSession();
        if ( session.getAttribute( ATT_USER_SESSION ) != null ) {
            session.removeAttribute( ATT_USER_SESSION );
            return;
        } else {
            return;
        }

    }
}
