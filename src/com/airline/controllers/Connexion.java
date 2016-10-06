package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.UserDao;
import com.airline.service.UserService;

/**
 * Servlet implementation class Connexion
 */
@WebServlet( "/Connexion" )
public class Connexion extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/connexion.jsp";
    private static final String VUE_REDIRECT     = "/jaxrs/admin/Home";

    private static final long   serialVersionUID = 1L;

    @EJB
    UserDao                     userDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        UserService userService = new UserService( userDao );
        userService.connectUser( request );

        request.setAttribute( "userService", userService );

        if ( userService.getResultat() == null ) {
            response.sendRedirect( VUE_REDIRECT );
        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }

    }

}
