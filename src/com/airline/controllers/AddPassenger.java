package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.FlightDao;
import com.airline.dao.PassengerDao;
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet( "/admin/AddPassenger" )
public class AddPassenger extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/AddPassenger.jsp";
    private static final String VUE_REDIRECT     = "/jaxrs/admin/PassengerList";
    private static final long   serialVersionUID = 1L;

    @EJB
    FlightDao                   flightDao;

    @EJB
    PilotDao                    pilotDao;

    @EJB
    PlaneDao                    planeDao;

    @EJB
    PassengerDao                passengerDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
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
        PassengerService passengerService = new PassengerService( passengerDao, flightDao, pilotDao, planeDao );
        Passenger passenger = passengerService.createPassenger( request );

        request.setAttribute( "passenger", passenger );
        request.setAttribute( "passengerService", passengerService );

        if ( passengerService.getErreurs().isEmpty() ) {
            response.sendRedirect( VUE_REDIRECT );
        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }

    }
}
