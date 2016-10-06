package com.airline.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.FlightDao;
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Cities;
import com.airline.models.Flight;
import com.airline.service.FlightService;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet( "/Index" )
public class SearchFlights extends HttpServlet {
    private static final String VUE                      = "/WEB-INF/views/SearchFlights.jsp";

    private static final String CHAMP_FLIGHT_ORIGIN      = "depart";
    private static final String CHAMP_FLIGHT_DESTINATION = "destination";
    private static final String CHAMP_FLIGHT_YEAR        = "year";
    private static final String CHAMP_FLIGHT_MONTH       = "month";
    private static final String CHAMP_FLIGHT_DAY         = "day";

    private static final long   serialVersionUID         = 1L;

    @EJB
    FlightDao                   flightDao;

    @EJB
    PilotDao                    pilotDao;

    @EJB
    PlaneDao                    planeDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFlights() {
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

        String dep = request.getParameter( CHAMP_FLIGHT_ORIGIN );
        String dest = request.getParameter( CHAMP_FLIGHT_DESTINATION );

        Cities depart = Cities.valueOf( dep );
        Cities destination = Cities.valueOf( dest );

        Integer year = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_YEAR ) );
        Integer month = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_MONTH ) );
        Integer day = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_DAY ) );

        request.setAttribute( "departFlight", depart );
        request.setAttribute( "destinationFlight", destination );
        request.setAttribute( "yearFlight", year );
        request.setAttribute( "monthFlight", month );
        request.setAttribute( "dayFlight", day );

        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );

        List<Flight> flights = flightService.searchFlights( request );

        request.setAttribute( "flights", flights );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

}
