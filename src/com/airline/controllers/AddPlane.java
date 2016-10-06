package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.PlaneDao;
import com.airline.models.Plane;
import com.airline.service.PlaneService;

/**
 * Servlet implementation class AddPlane
 */
@WebServlet( "/admin/AddPlane" )
public class AddPlane extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/AddPlane.jsp";
    private static final String VUE_REDIRECT     = "/jaxrs/admin/AirplaneList";
    private static final long   serialVersionUID = 1L;

    @EJB
    PlaneDao                    planeDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlane() {
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
        PlaneService planeService = new PlaneService( planeDao );

        Plane plane = planeService.createPlane( request );

        request.setAttribute( "plane", plane );
        request.setAttribute( "planeService", planeService );

        if ( planeService.getErreurs().isEmpty() ) {
            response.sendRedirect( VUE_REDIRECT );
        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }

}
