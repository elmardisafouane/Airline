package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.FlightDao;
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Flight;
import com.airline.service.FlightService;

/**
 * Servlet implementation class RemoveFlight
 */
@WebServlet( "/admin/RemoveFlight" )
public class RemoveFlight extends HttpServlet {
    private static final String CHAMP_ID_FLIGHT  = "idFlight";
    public static final String  VUE_REDIRECT     = "/admin/FlightList";
    private static final long   serialVersionUID = 1L;

    @EJB
    FlightDao                   flightDao;
    @EJB
    PlaneDao                    planeDao;
    @EJB
    PilotDao                    pilotDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );
        String idFlight = request.getParameter( CHAMP_ID_FLIGHT );
        Flight flight = flightService.getFlightById( idFlight );
        flightService.removeFlight( flight );
        response.sendRedirect( request.getContextPath() + VUE_REDIRECT );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    }

}
